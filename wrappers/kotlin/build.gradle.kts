import com.google.wireless.android.sdk.stats.GradleBuildVariant.KotlinOptions
import org.jetbrains.kotlin.gradle.plugin.KotlinTargetHierarchy
import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask
import java.util.*

buildscript{
    repositories{
        mavenCentral()
    }
    dependencies{
        classpath("org.jetbrains.kotlinx:atomicfu-gradle-plugin:0.22.0")
    }

}
apply(plugin = "kotlinx-atomicfu")

plugins {
    kotlin("multiplatform") version "1.8.21"
    kotlin("plugin.serialization") version "1.8.21"
    id("maven-publish")
    id("com.android.library") version "7.4.0"
}

val askarBindings = file("askarBindings")
val binaries = file("../../target")


val processBinaries = tasks.register("processBinaries", Copy::class) {
    val directory = buildDir
        .resolve("processedResources")
        .resolve("jvm")
        .resolve("main")

    from(binaries.resolve("darwin-universal").resolve("release"))
    include("*.dylib")
    include("*.so")
    into(directory)
}

tasks.withType<ProcessResources>{
    dependsOn(processBinaries)
}

// Stub secrets to let the project sync and build without the publication values set up
ext["githubUsername"] = null
ext["githubToken"] = null
ext["askarVersion"] = "0.2.9-dev.3"
ext["wrapperVersion"] = "3.4"

val secretPropsFile = project.rootProject.file("local.properties")
if(secretPropsFile.exists()) {
    secretPropsFile.reader().use {
        Properties().apply {
            load(it)
        }
    }.onEach{ (name, value) ->
        ext[name.toString()] = value
    }
} else {
    ext["githubUsername"] = System.getenv("GITHUB_USERNAME")
    ext["githubToken"] = System.getenv("GITHUB_TOKEN")
}

fun getExtraString(name: String) = ext[name]?.toString()

group = "org.hyperledger.aries-askar"
version = "${getExtraString("askarVersion")}-wrapper.${getExtraString("wrapperVersion")}"
dependencies {
    testImplementation("androidx.test:monitor:1.6.1")
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
    testImplementation("org.testng:testng:7.1.0")
    testImplementation("org.testng:testng:7.1.0")
}

publishing{
    repositories{
        maven{
            name = "github"
            setUrl("https://maven.pkg.github.com/indicio-tech/aries-askar")
            credentials {
                username = getExtraString("githubUsername")
                password = getExtraString("githubToken")
            }
        }
    }

    publications.withType<MavenPublication> {
        pom {
            name.set("Aries Askar Kotlin")
            description.set("Kotlin MPP wrapper around aries-askar")
            url.set("https://github.com/indicio-tech/aries-askar")

            scm{
                url.set("https://github.com/indicio-tech/aries-askar")
            }
        }
    }
}



private enum class PlatformType {
    APPLE,
    ANDROID
}

kotlin {
    targetHierarchy.default()

    fun addLibs(libDirectory: String, target: KotlinNativeTarget) {
        target.compilations.getByName("main") {
            val uniffi by cinterops.creating {
                includeDirs(
                    projectDir.absolutePath + "/src/nativeInterop/cinterop/headers/aries_askar/"
                )
                packageName("aries_askar.cinterop")
                extraOpts("-libraryPath", libDirectory)
            }
        }

        target.binaries.all {
            linkerOpts("-L${libDirectory}", "-laries_askar")
            linkerOpts("-Wl,-framework,Security")
        }
    }

    androidTarget{
        compilations.all{
            kotlinOptions.jvmTarget = "1.8"
        }
        instrumentedTestVariant.sourceSetTree.set(KotlinTargetHierarchy.SourceSetTree.test)
        unitTestVariant.sourceSetTree.set(KotlinTargetHierarchy.SourceSetTree.unitTest)
    }

    jvm{
        compilations.all{
            kotlinOptions.jvmTarget = "1.8"
            this.kotlinOptions {
                freeCompilerArgs += listOf("-Xdebug")
            }
        }
        testRuns["test"].executionTask.configure{
            useJUnitPlatform()
        }

    }

    macosX64{
        val libDirectory = "${projectDir}/../../target/x86_64-apple-darwin/release"
        addLibs(libDirectory, this)
    }

    macosArm64{
        val libDirectory = "${projectDir}/../../target/aarch64-apple-darwin/release"
        addLibs(libDirectory, this)
    }

    iosX64 {
        val libDirectory = "${projectDir}/../../target/x86_64-apple-ios/release"
        addLibs(libDirectory, this)
    }

    iosSimulatorArm64 {
        val libDirectory = "${projectDir}/../../target/aarch64-apple-ios-sim/release"
        addLibs(libDirectory, this)
    }

    iosArm64 {
        val libDirectory = "${projectDir}/../../target/aarch64-apple-ios/release"
        addLibs(libDirectory, this)
    }

    sourceSets {

        all {
          languageSettings.optIn("kotlinx.cinterop.ExperimentalForeignApi")
        }

        val commonMain by getting {
            kotlin.srcDir(askarBindings.resolve("commonMain").resolve("kotlin"))
            dependencies {
                implementation("com.squareup.okio:okio:3.2.0")
                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0-RC")
            }
        }

        val commonTest by getting {
            dependencies{
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            kotlin.srcDir(binaries)
            kotlin.srcDir(askarBindings.resolve("jvmMain").resolve("kotlin"))
            dependencies{
                implementation("net.java.dev.jna:jna:5.7.0@aar")
                implementation("org.jetbrains.kotlinx:atomicfu:0.22.0")
            }
            dependsOn(commonMain)
        }

        val jvmMain by getting {
            kotlin.srcDir(binaries)
            kotlin.srcDir(askarBindings.resolve("jvmMain").resolve("kotlin"))
            dependencies{
                implementation("net.java.dev.jna:jna:5.13.0")
            }
            dependsOn(commonMain)
        }

        val jvmTest by getting {
            dependsOn(commonTest)
        }

        val nativeMain by getting {
            kotlin.srcDir(askarBindings.resolve("nativeMain").resolve("kotlin"))
        }

        val nativeTest by getting{
            dependsOn(nativeMain)
        }
    }
}


android{
    sourceSets["main"].jniLibs.srcDir("src/androidMain/jniLibs")
    apply(plugin = "kotlinx-atomicfu")
    namespace = "askar"
    compileSdk = 33
    defaultConfig{
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        minSdk = 24

        testOptions {
            execution = "ANDROIDX_TEST_ORCHESTRATOR"
        }
    }

    dependencies {
        androidTestImplementation("androidx.test:runner:1.5.2")
        androidTestUtil("androidx.test:orchestrator:1.4.2")
    }
}