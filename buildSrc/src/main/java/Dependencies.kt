@file:Suppress("detekt.UtilityClassWithPublicConstructor", "detekt.TopLevelPropertyNaming")

@Suppress("detekt.TopLevelPropertyNaming")
const val kotlinVersion = "1.3.60"

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "4.0.0-alpha06"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"

}

object AndroidSdk {
    const val min = 21
    const val compile = 29
    const val target = compile
}

object Libraries {
    object Versions {
        const val jetpack = "1.2.0-alpha01"
        const val constraintLayout = "1.1.2"
        const val ktx = "1.0.0"
        const val material = "1.2.0-alpha02"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val material = "com.google.android.material:material:${Versions.material}"
}

object TestLibraries {
    private object Versions {
        const val junit4 = "4.12"
        const val testRunner = "1.1.0-alpha4"
        const val espresso = "3.1.0-alpha4"
    }

    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testRunner = "androidx.test:runner:${Versions.testRunner}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}

object DI {
    private const val toothpick = "3.1.0"

    const val toothpickRuntime = "com.github.stephanenicolas.toothpick:toothpick-runtime:$toothpick"
    const val toothpickSmoothie = "com.github.stephanenicolas.toothpick:smoothie:$toothpick"
    const val toothpickCompiler = "com.github.stephanenicolas.toothpick:toothpick-compiler:$toothpick"
}