#include <ariesAskar.h>

#include <include/libaries_askar.h>

using namespace turboModuleUtility;

namespace ariesAskar {

jsi::Value version(jsi::Runtime &rt, jsi::Object options) {
  return jsi::String::createFromAscii(rt, askar_version());
};

jsi::Value getCurrentError(jsi::Runtime &rt, jsi::Object options) {
  const char *error;
  askar_get_current_error(&error);
  return jsi::String::createFromAscii(rt, error);
};

jsi::Value entryListCount(jsi::Runtime &rt, jsi::Object options) {
    EntryListHandle handle =
        turboModuleUtility::jsiToValue<EntryListHandle>(rt, options, "entryListHandle");
    
    int32_t out;
    
    ErrorCode code = askar_entry_list_count(handle, &out);
    handleError(rt, code);

    return jsi::Value(out);

};
jsi::Value entryListFree(jsi::Runtime &rt, jsi::Object options) {
    EntryListHandle handle =
        turboModuleUtility::jsiToValue<EntryListHandle>(rt, options, "entryListHandle");

    askar_entry_list_free(handle);

    return jsi::Value::null();
}

jsi::Value entryListGetCategory(jsi::Runtime &rt, jsi::Object options) {
    EntryListHandle handle =
        turboModuleUtility::jsiToValue<EntryListHandle>(rt, options, "entryListHandle");
    int32_t index =
        turboModuleUtility::jsiToValue<int32_t>(rt, options, "index");

    const char* out;
    
    ErrorCode code = askar_entry_list_get_category(handle, index, &out);
    handleError(rt, code);

    return jsi::String::createFromAscii(rt, out);
}

jsi::Value entryListGetTags(jsi::Runtime &rt, jsi::Object options) {
    EntryListHandle handle =
        turboModuleUtility::jsiToValue<EntryListHandle>(rt, options, "entryListHandle");
    int32_t index =
        turboModuleUtility::jsiToValue<int32_t>(rt, options, "index");

    const char* out;
    
    ErrorCode code = askar_entry_list_get_tags(handle, index, &out);
    handleError(rt, code);

    return jsi::String::createFromAscii(rt, out ? out : "{}");
}

jsi::Value entryListGetValue(jsi::Runtime &rt, jsi::Object options) {
    EntryListHandle handle =
        turboModuleUtility::jsiToValue<EntryListHandle>(rt, options, "entryListHandle");
    int32_t index =
        turboModuleUtility::jsiToValue<int32_t>(rt, options, "index");

    // TODO: convert to uint8array like bytebuffer
    SecretBuffer out;
    
    ErrorCode code = askar_entry_list_get_value(handle, index, &out);
    handleError(rt, code);

    return jsi::Value::null();
}

jsi::Value entryListGetName(jsi::Runtime &rt, jsi::Object options) {
    EntryListHandle handle =
        turboModuleUtility::jsiToValue<EntryListHandle>(rt, options, "entryListHandle");
    int32_t index =
        turboModuleUtility::jsiToValue<int32_t>(rt, options, "index");

    const char* out;
    
    ErrorCode code = askar_entry_list_get_name(handle, index, &out);
    handleError(rt, code);

    return jsi::String::createFromAscii(rt, out);
}

jsi::Value storeOpen(jsi::Runtime &rt, jsi::Object options) {
  std::string specUri =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "specUri");
  std::string keyMethod = turboModuleUtility::jsiToValue<std::string>(
      rt, options, "keyMethod", true);
  std::string passKey =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "passKey", true);
  std::string profile =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "profile", true);

  jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
  State *state = new State(&cb);
  state->rt = &rt;

  ErrorCode code = askar_store_open(
      specUri.c_str(), keyMethod.length() ? keyMethod.c_str() : nullptr,
      passKey.length() ? passKey.c_str() : nullptr,
      profile.length() ? profile.c_str() : nullptr,
      turboModuleUtility::callbackWithResponse, CallbackId(state));

  turboModuleUtility::handleError(rt, code);

  return jsi::Value::null();
}

jsi::Value storeProvision(jsi::Runtime &rt, jsi::Object options) {
  std::string specUri =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "specUri");
  std::string keyMethod = turboModuleUtility::jsiToValue<std::string>(
      rt, options, "keyMethod", true);
  std::string passKey =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "passKey", true);
  std::string profile =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "profile", true);
  int8_t recreate =
      turboModuleUtility::jsiToValue<int8_t>(rt, options, "recreate");

  jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
  State *state = new State(&cb);
  state->rt = &rt;

  ErrorCode code = askar_store_provision(
      specUri.c_str(), keyMethod.length() ? keyMethod.c_str() : nullptr,
      passKey.length() ? passKey.c_str() : nullptr,
      profile.length() ? profile.c_str() : nullptr, recreate,
      turboModuleUtility::callbackWithResponse, CallbackId(state));
  turboModuleUtility::handleError(rt, code);

  return jsi::Value::null();
}

jsi::Value storeGenerateRawKey(jsi::Runtime &rt, jsi::Object options) {
  ByteBuffer seed =
      turboModuleUtility::jsiToValue<ByteBuffer>(rt, options, "seed", true);

  const char *out;
  ErrorCode code = askar_store_generate_raw_key(seed, &out);
  turboModuleUtility::handleError(rt, code);

  return jsi::String::createFromAscii(rt, out);
}

jsi::Value storeClose(jsi::Runtime &rt, jsi::Object options) {
  int64_t handle =
      turboModuleUtility::jsiToValue<int64_t>(rt, options, "storeHandle");

  jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
  State *state = new State(&cb);
  state->rt = &rt;

  ErrorCode code = askar_store_close(handle, turboModuleUtility::callback,
                                     CallbackId(state));
  turboModuleUtility::handleError(rt, code);

  return jsi::Value::null();
}

jsi::Value storeCreateProfile(jsi::Runtime &rt, jsi::Object options) {
  int64_t handle =
      turboModuleUtility::jsiToValue<int64_t>(rt, options, "storeHandle");
  std::string profile =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "profile");

  jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
  State *state = new State(&cb);
  state->rt = &rt;

  ErrorCode code = askar_store_create_profile(
      handle, profile.c_str(), turboModuleUtility::callbackWithResponse,
      CallbackId(state));
  turboModuleUtility::handleError(rt, code);

  return jsi::Value::null();
}

jsi::Value storeGetProfileName(jsi::Runtime &rt, jsi::Object options) {
  int64_t handle =
      turboModuleUtility::jsiToValue<int64_t>(rt, options, "storeHandle");

  jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
  State *state = new State(&cb);
  state->rt = &rt;

  ErrorCode code = askar_store_get_profile_name(
      handle, turboModuleUtility::callbackWithResponse, CallbackId(state));
  turboModuleUtility::handleError(rt, code);

  return jsi::Value::null();
}

jsi::Value storeRekey(jsi::Runtime &rt, jsi::Object options) {
  int64_t handle =
      turboModuleUtility::jsiToValue<int64_t>(rt, options, "storeHandle");
  std::string keyMethod =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "keyMethod");
  std::string passKey =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "passKey");

  jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
  State *state = new State(&cb);
  state->rt = &rt;

  ErrorCode code = askar_store_get_profile_name(
      StoreHandle(handle), turboModuleUtility::callbackWithResponse,
      CallbackId(state));
  turboModuleUtility::handleError(rt, code);

  return jsi::Value::null();
}

jsi::Value storeRemove(jsi::Runtime &rt, jsi::Object options) {
  std::string specUri =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "specUri");

  jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
  State *state = new State(&cb);
  state->rt = &rt;

  ErrorCode code = askar_store_remove(specUri.c_str(),
                                      turboModuleUtility::callbackWithResponse,
                                      CallbackId(state));
  turboModuleUtility::handleError(rt, code);

  return jsi::Value::null();
}

jsi::Value storeRemoveProfile(jsi::Runtime &rt, jsi::Object options) {
  int64_t handle =
      turboModuleUtility::jsiToValue<int64_t>(rt, options, "storeHandle");
  std::string profile =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "profile");

  jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
  State *state = new State(&cb);
  state->rt = &rt;

  ErrorCode code = askar_store_remove_profile(
      StoreHandle(handle), profile.c_str(),
      turboModuleUtility::callbackWithResponse, CallbackId(state));
  turboModuleUtility::handleError(rt, code);

  return jsi::Value::null();
}

jsi::Value sessionClose(jsi::Runtime &rt, jsi::Object options) {
  int64_t handle =
      turboModuleUtility::jsiToValue<int64_t>(rt, options, "sessionHandle");
  int8_t commit = turboModuleUtility::jsiToValue<int8_t>(rt, options, "commit");

  jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
  State *state = new State(&cb);
  state->rt = &rt;

  ErrorCode code =
      askar_session_close(SessionHandle(handle), commit,
                          turboModuleUtility::callback, CallbackId(state));
  turboModuleUtility::handleError(rt, code);

  return jsi::Value::null();
}

jsi::Value sessionCount(jsi::Runtime &rt, jsi::Object options) {
  int64_t handle =
      turboModuleUtility::jsiToValue<int64_t>(rt, options, "sessionHandle");
  std::string category =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "category");
  std::string tagFilter =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "tagFilter");

  jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
  State *state = new State(&cb);
  state->rt = &rt;

  ErrorCode code = askar_session_count(
      SessionHandle(handle), category.c_str(), tagFilter.c_str(),
      turboModuleUtility::callbackWithResponse, CallbackId(state));
  turboModuleUtility::handleError(rt, code);

  return jsi::Value::null();
}

jsi::Value sessionFetch(jsi::Runtime &rt, jsi::Object options) {
    int64_t handle =
          turboModuleUtility::jsiToValue<int64_t>(rt, options,
          "sessionHandle");
    std::string category =
          turboModuleUtility::jsiToValue<std::string>(rt, options,
          "category");
    std::string name =
          turboModuleUtility::jsiToValue<std::string>(rt, options, "name");
    int8_t forUpdate =
          turboModuleUtility::jsiToValue<int8_t>(rt, options, "forUpdate");
  
    jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
    State *state = new State(&cb);
    state->rt = &rt;
  
    ErrorCode code = askar_session_fetch(SessionHandle(handle),
    category.c_str(),name.c_str(),forUpdate,
    turboModuleUtility::callbackWithResponse, CallbackId(state));
    turboModuleUtility::handleError(rt, code);
  
  return jsi::Value::null();
}

jsi::Value sessionFetchAll(jsi::Runtime &rt, jsi::Object options) {
  //  int64_t handle =
  //        turboModuleUtility::jsiToValue<int64_t>(rt, options,
  //        "sessionHandle");
  //  std::string category =
  //        turboModuleUtility::jsiToValue<std::string>(rt, options,
  //        "category");
  //  std::string tagFilter =
  //        turboModuleUtility::jsiToValue<std::string>(rt, options,
  //        "tagFilter");
  //  int64_t limit =
  //        turboModuleUtility::jsiToValue<int64_t>(rt, options, "limit");
  //  int8_t forUpdate =
  //        turboModuleUtility::jsiToValue<int8_t>(rt, options, "forUpdate");
  //
  //  jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
  //  State *state = new State(&cb);
  //  state->rt = &rt;
  //
  //  ErrorCode code = askar_session_fetch_all(SessionHandle(handle),
  //  category.c_str(), tagFilter.c_str(), limit, forUpdate,
  //  turboModuleUtility::callbackWithResponse, CallbackId(state));
  //  turboModuleUtility::handleError(rt, code);

  return jsi::Value::null();
}

jsi::Value sessionFetchAllKeys(jsi::Runtime &rt, jsi::Object options) {
  //  int64_t handle =
  //        turboModuleUtility::jsiToValue<int64_t>(rt, options,
  //        "sessionHandle");
  //  std::string alg =
  //        turboModuleUtility::jsiToValue<std::string>(rt, options, "alg");
  //  std::string thumbprint =
  //        turboModuleUtility::jsiToValue<std::string>(rt, options,
  //        "thumbprint");
  //  std::string tagFilter =
  //        turboModuleUtility::jsiToValue<std::string>(rt, options,
  //        "tagFilter");
  //  int64_t limit =
  //        turboModuleUtility::jsiToValue<int64_t>(rt, options, "limit");
  //  int8_t forUpdate =
  //        turboModuleUtility::jsiToValue<int8_t>(rt, options, "forUpdate");
  //
  //  jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
  //  State *state = new State(&cb);
  //  state->rt = &rt;
  //
  //  ErrorCode code = askar_session_fetch_all_keys(SessionHandle(handle),
  //  alg.c_str(), thumbprint.c_str(), tagFilter.c_str(), limit, forUpdate,
  //  turboModuleUtility::callbackWithResponse, CallbackId(state));
  //  turboModuleUtility::handleError(rt, code);

  return jsi::Value::null();
}

jsi::Value sessionFetchKey(jsi::Runtime &rt, jsi::Object options) {
  //  int64_t handle =
  //        turboModuleUtility::jsiToValue<int64_t>(rt, options,
  //        "sessionHandle");
  //  std::string name =
  //        turboModuleUtility::jsiToValue<std::string>(rt, options, "name");
  //  int8_t forUpdate =
  //        turboModuleUtility::jsiToValue<int8_t>(rt, options, "forUpdate");
  //
  //  jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
  //  State *state = new State(&cb);
  //  state->rt = &rt;
  //
  //  ErrorCode code = askar_session_fetch_key(SessionHandle(handle),
  //  name.c_str(), forUpdate, turboModuleUtility::callbackWithResponse,
  //  CallbackId(state)); turboModuleUtility::handleError(rt, code);

  return jsi::Value::null();
}

// TODO: how to deal with localKeyHandle
jsi::Value sessionInsertKey(jsi::Runtime &rt, jsi::Object options) {
  //  int64_t handle =
  //        turboModuleUtility::jsiToValue<int64_t>(rt, options,
  //        "sessionHandle");
  //  LocalKeyHandle localKeyHandle =
  //        turboModuleUtility::jsiToValue<LocalKeyHandle>(rt, options,
  //        "localKeyHandle");
  //  std::string name =
  //        turboModuleUtility::jsiToValue<std::string>(rt, options, "name");
  //  std::string metadata =
  //        turboModuleUtility::jsiToValue<std::string>(rt, options,
  //        "metadata");
  //  std::string tags =
  //        turboModuleUtility::jsiToValue<std::string>(rt, options, "tags");
  //  int64_t expiryMs =
  //        turboModuleUtility::jsiToValue<int64_t>(rt, options, "expiryMs");
  //
  //  jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
  //  State *state = new State(&cb);
  //  state->rt = &rt;
  //
  //  ErrorCode code = askar_session_insert_key(SessionHandle(handle),
  //  localKeyHandle, name.c_str(), metadata.c_str(), tags.c_str(), expiryMs,
  //  turboModuleUtility::callback, CallbackId(state));
  //  turboModuleUtility::handleError(rt, code);

  return jsi::Value::null();
}

jsi::Value sessionRemoveAll(jsi::Runtime &rt, jsi::Object options) {
  int64_t handle =
      turboModuleUtility::jsiToValue<int64_t>(rt, options, "sessionHandle");
  std::string category =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "category");
  std::string tagFilter =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "tagFilter");

  jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
  State *state = new State(&cb);
  state->rt = &rt;

  ErrorCode code = askar_session_remove_all(
      SessionHandle(handle), category.c_str(), tagFilter.c_str(),
      turboModuleUtility::callbackWithResponse, CallbackId(state));

  turboModuleUtility::handleError(rt, code);

  return jsi::Value::null();
}

jsi::Value sessionRemoveKey(jsi::Runtime &rt, jsi::Object options) {
  int64_t handle =
      turboModuleUtility::jsiToValue<int64_t>(rt, options, "sessionHandle");
  std::string name =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "name");

  jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
  State *state = new State(&cb);
  state->rt = &rt;

  ErrorCode code =
      askar_session_remove_key(SessionHandle(handle), name.c_str(),
                               turboModuleUtility::callback, CallbackId(state));

  turboModuleUtility::handleError(rt, code);

  return jsi::Value::null();
}

jsi::Value sessionStart(jsi::Runtime &rt, jsi::Object options) {
  int64_t handle =
      turboModuleUtility::jsiToValue<int64_t>(rt, options, "storeHandle");
  std::string profile =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "profile", true);
  int8_t asTransaction =
      turboModuleUtility::jsiToValue<int8_t>(rt, options, "asTransaction");

  jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
  State *state = new State(&cb);
  state->rt = &rt;

  ErrorCode code = askar_session_start(
      StoreHandle(handle), profile.length() ? profile.c_str() : nullptr,
      asTransaction, turboModuleUtility::callbackWithResponse,
      CallbackId(state));

  turboModuleUtility::handleError(rt, code);

  return jsi::Value::null();
}

jsi::Value sessionUpdate(jsi::Runtime &rt, jsi::Object options) {
  int64_t handle =
      turboModuleUtility::jsiToValue<int64_t>(rt, options, "sessionHandle");
  int8_t operation =
      turboModuleUtility::jsiToValue<int8_t>(rt, options, "operation");
  std::string category =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "category");
  std::string name =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "name");
  std::string tags =
      turboModuleUtility::jsiToValue<std::string>(rt, options, "tags", true);
  ByteBuffer value =
      turboModuleUtility::jsiToValue<ByteBuffer>(rt, options, "value");
  int64_t expiryMs =
      turboModuleUtility::jsiToValue<int64_t>(rt, options, "expiryMs", true);

  jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
  State *state = new State(&cb);
  state->rt = &rt;

  ErrorCode code = askar_session_update(
      SessionHandle(handle), operation, category.c_str(), name.c_str(), value,
      tags.length() ? tags.c_str() : nullptr, expiryMs, turboModuleUtility::callback, CallbackId(state));

  turboModuleUtility::handleError(rt, code);

  return jsi::Value::null();
}

jsi::Value sessionUpdateKey(jsi::Runtime &rt, jsi::Object options) {
  //  int64_t handle =
  //        turboModuleUtility::jsiToValue<int64_t>(rt, options,
  //        "sessionHandle");
  //  std::string name =
  //        turboModuleUtility::jsiToValue<std::string>(rt, options, "name");
  //  std::string tags =
  //        turboModuleUtility::jsiToValue<std::string>(rt, options, "tags");
  //  std::string metadata =
  //        turboModuleUtility::jsiToValue<std::string>(rt, options,
  //        "metadata");
  //  int64_t expiryMs =
  //        turboModuleUtility::jsiToValue<int64_t>(rt, options, "expiryMs");
  //
  //  jsi::Function cb = options.getPropertyAsFunction(rt, "cb");
  //  State *state = new State(&cb);
  //  state->rt = &rt;
  //
  //  ErrorCode code = askar_session_update_key(SessionHandle(handle),
  //  name.c_str(), metadata.c_str(), tags.c_str(),expiryMs,
  //  turboModuleUtility::callback, CallbackId(state));
  //
  //  turboModuleUtility::handleError(rt, code);
  //
  return jsi::Value::null();
}

} // namespace ariesAskar
