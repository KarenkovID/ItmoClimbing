plugins {
    id(BuildPlugins.androidApplication)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id("kotlin-kapt")
}

val staticAnalysisDir: String by rootProject.extra
apply(from = "$rootDir/dependenciesGraph.gradle")
apply(from = "$staticAnalysisDir/lint.gradle")

android {
    //solves problem
    //https://stackoverflow.com/questions/45232350/disable-meta-inf-generation-in-gradle-android-library-kotlin-project/45235642#45235642
    packagingOptions {
        exclude("META-INF/presentation_*.kotlin_module")
        exclude("META-INF/api_*.kotlin_module")
        exclude("META-INF/domain_*.kotlin_module")
        exclude("META-INF/data_*.kotlin_module")
    }
    compileSdkVersion(AndroidSdk.compile)

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
                        "support_obfuscation" to "true"
                )
            }
        }
    }

    buildTypes {
        getByName("release") {
            isShrinkResources = true
            isMinifyEnabled = true
            setProguardFiles(
                    listOf(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "toothpick.pro",
                            "proguard-rules.pro"
                    )
            )
            signingConfig = signingConfigs["debug"]
        }
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }

}

dependencies {
    implementation(project(":domainCommon"))
    implementation(project(":dataCommon"))
    implementation(project(Features.routes.api))
    implementation(project(Features.users.api))
    implementation(project(Projects.androidCore))
    implementation(project(Projects.domainCore))
    implementation(project(Features.common))

    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
    implementation(Libraries.ktxCore)
    implementation(Libraries.constraintLayout)

    testImplementation(TestLibraries.junit4)
    androidTestImplementation(TestLibraries.testRunner)
    androidTestImplementation(TestLibraries.espresso)

    implementation(DI.toothpickRuntime)
    implementation(DI.toothpickSmoothie)
    kapt(DI.toothpickCompiler)

    implementation(Libraries.cicerone)
    implementation(Libraries.material)

    implementation(Libraries.rxJava)
    implementation(Libraries.rxKotlin)
    implementation(Libraries.rxAndroid)

    debugImplementation(DebugLibraries.leakcanary)

    implementation(Libraries.androidLifecycleExtensions)
}
