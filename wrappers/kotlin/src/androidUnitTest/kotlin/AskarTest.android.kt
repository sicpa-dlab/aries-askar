import androidx.test.platform.app.InstrumentationRegistry

actual fun databaseUri(): String {
    val a = InstrumentationRegistry.getInstrumentation().targetContext
    return a.filesDir.absolutePath
}
