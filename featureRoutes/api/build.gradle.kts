plugins {
    id(BuildPlugins.androidLibrary)
    id(BuildPlugins.kotlinAndroid)
    id(BuildPlugins.kotlinAndroidExtensions)
    id(BuildPlugins.kotlinKapt)
}

android {
    compileSdkVersion(AndroidSdk.compile)

    sourceSets {
        getByName("main").java.srcDirs("src/main/kotlin")
    }

}

apply(from = "$rootDir/dependencies.gradle.kts")

dependencies {
    implementation(project(":featureRoutes:presentation"))
    implementation(project(Projects.presentationCommon))

    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)

    implementation(DI.toothpickRuntime)
    implementation(DI.toothpickSmoothie)
    kapt(DI.toothpickCompiler)
}
