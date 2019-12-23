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
    implementation(project(":featureRoutesPresentation"))

    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
}
