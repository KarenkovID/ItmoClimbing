import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id("kotlin-kapt")
}

val staticAnalysisDir: String by rootProject.extra
apply(from = "$staticAnalysisDir/lint.gradle")

android {
    compileSdkVersion(29)

    defaultConfig {
        applicationId = "com.kommander.itmoclimbing"
        minSdkVersion(AndroidSdk.min)
        targetSdkVersion(AndroidSdk.target)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                arguments = mapOf(
                    "toothpick_registry_package_name" to "com.itmoclimbing.app",
                    "toothpick_registry_children_package_names" to "com.itmoclimbing.domain,com.itmoclimbing.data",
                    "support_obfuscation" to "true"
                )
            }
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            setProguardFiles(
                listOf(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            )
        }
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }

}

apply(from = "$rootDir/dependencies.gradle.kts")

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(kotlin("stdlib", KotlinCompilerVersion.VERSION))

    val deps: Map<String, String> by rootProject.extra

    implementation(deps.getValue("kotlinStdLib"))
    implementation(deps.getValue("appCompat"))
    implementation(deps.getValue("ktxCore"))
    implementation(deps.getValue("constraintLayout"))

    val testDeps: Map<String, String> by rootProject.extra
    testImplementation(testDeps.getValue("junit4"))
    androidTestImplementation(testDeps.getValue("testRunner"))
    androidTestImplementation(testDeps.getValue("espresso"))

    implementation(DI.toothpickRuntime)
    implementation(DI.toothpickSmoothie)
    kapt(DI.toothpickCompiler)

    implementation(Libraries.cicerone)
    implementation(Libraries.material)

    implementation(Libraries.rxJava)
    implementation(Libraries.rxKotlin)
    implementation(Libraries.rxAndroid)

    implementation("android.arch.lifecycle:extensions:1.1.1")
    annotationProcessor("android.arch.lifecycle:compiler:1.1.1")
//    implementation("androidx.appcompat:appcompat:1.1.0")
//    implementation("androidx.core:core-ktx:1.1.0")
//    implementation("androidx.constraintlayout:constraintlayout:1.1.3")
//    testImplementation("junit:junit:4.12")
//    androidTestImplementation("androidx.test.ext:junit:1.1.1")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")
}
