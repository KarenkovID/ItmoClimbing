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
                        "toothpick_registry_package_name" to "com.itmoclimbing.app",
                        "toothpick_registry_children_package_names" to "com.itmoclimbing.domainCommon,com.itmoclimbing.dataCommon",
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

dependencies {
    implementation(project(":domainCommon"))
    implementation(project(":dataCommon"))
    implementation(project(Features.routes))
    implementation(project(Features.users))
    implementation(project(Projects.presentationCommon))
    implementation(project(Projects.androidCore))
    implementation(project(Projects.domainCore))
    implementation(project(Projects.featuresCommon))

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

    implementation(DebugLibraries.leakcanary)

    implementation(Libraries.androidLifecycleExtensions)
    annotationProcessor(Libraries.androidLifecycleCompiler)
}
