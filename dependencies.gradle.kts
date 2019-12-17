val buildToolsVersion = "4.0.0-alpha06"
val jetpack = "1.2.0-alpha01"
val constraintLayout = "1.1.2"
val ktx = "1.0.0"
val toothPick = "3.1.0"

val minSdk: Int by extra(21)
val compileSdk: Int by extra(29)
val kotlinVersion: String by extra("1.3.60")

val deps: Map<String, String> by extra(
    mapOf(
        "kotlinStdLib" to "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion",
        "appCompat" to "androidx.appcompat:appcompat:$jetpack",
        "constraintLayout" to "androidx.constraintlayout:constraintlayout:$constraintLayout",
        "ktxCore" to "androidx.core:core-ktx:$ktx",

        "toothpickRuntime" to "com.github.stephanenicolas.toothpick:toothpick-runtime:$toothPick",
        "toothpickSmoothie" to "com.github.stephanenicolas.toothpick:smoothie:$toothPick",
        "toothpickCompiler" to "com.github.stephanenicolas.toothpick:toothpick-compiler:$toothPick"
    )
)

val androidGradlePlugin: String by extra("com.android.tools.build:gradle:$buildToolsVersion")
val kotlinGradlePlugin: String by extra("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
val androidApplication: String by extra("com.android.application")
val kotlinAndroid: String by extra("kotlin-android")
val kotlinAndroidExtensions: String by extra("kotlin-android-extensions")

val junit4 = "4.12"
val testRunner = "1.1.0-alpha4"
val espresso = "3.1.0-alpha4"

val testDeps: Map<String, String> by extra(
    mapOf(
        "junit4" to "junit:junit:$junit4",
        "testRunner" to "androidx.test:runner:$testRunner",
        "espresso" to "androidx.test.espresso:espresso-core:$espresso"
    )
)