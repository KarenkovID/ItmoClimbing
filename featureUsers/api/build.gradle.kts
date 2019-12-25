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

dependencies {
    implementation(project(":featureUsers:presentation"))
    implementation(project(Projects.featuresCommon))

    implementation(Libraries.kotlinStdLib)
    implementation(Libraries.appCompat)
}
