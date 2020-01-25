plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinKapt)
}

val staticAnalysisDir: String by rootProject.extra
apply(from = "$staticAnalysisDir/lint.gradle")

android {
    compileSdkVersion(AndroidSdk.compile)

    defaultConfig {
        minSdkVersion(AndroidSdk.min)
    }

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }

}

dependencies {
    implementation(project(Features.routes.presentation))
    implementation(project(Features.common))

    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)

    implementation(DI.toothpickRuntime)
    implementation(DI.toothpickSmoothie)
    kapt(DI.toothpickCompiler)
}
