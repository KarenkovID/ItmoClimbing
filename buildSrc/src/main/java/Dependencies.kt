@file:Suppress("detekt.UtilityClassWithPublicConstructor", "detekt.TopLevelPropertyNaming")

@Suppress("detekt.TopLevelPropertyNaming")
const val kotlinVersion = "1.3.61"

object BuildPlugins {

    object Versions {
        const val buildToolsVersion = "3.5.3"
    }

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.buildToolsVersion}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"
    const val kotlin = "kotlin"

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
        const val material = "1.0.0"
        const val androidLifecycleVersion = "1.1.1"
        const val okhttp = "3.14.4"
        const val moshi = "1.9.2"
        const val retrofit = "2.7.0"
        const val room = "2.2.2"
    }

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.jetpack}"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.ktx}"
    const val material = "com.google.android.material:material:${Versions.material}"
    const val cicerone = "ru.terrakok.cicerone:cicerone:5.0.0"
    const val adapterDelegates = "com.hannesdorfmann:adapterdelegates4:4.2.0"
    const val timber = "com.jakewharton.timber:timber:4.7.1"
    const val androidLifecycleExtensions = "android.arch.lifecycle:extensions:${Versions.androidLifecycleVersion}"

    const val rxJava = "io.reactivex.rxjava2:rxjava:2.2.16"
    const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:2.4.0"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:2.1.1"
    const val glide = "com.github.bumptech.glide:glide:4.11.0"

    const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
    const val okhttpLogInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttp}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofitRxAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val retrofitScalarsConverter = "com.squareup.retrofit2:converter-scalars:${Versions.retrofit}"
    const val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofit}"
    const val moshi = "com.squareup.moshi:moshi:${Versions.moshi}"
    const val moshiCompiler = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshi}"

    const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.room}"
    const val roomRx = "androidx.room:room-rxjava2:${Versions.room}"

}

object DebugLibraries {
    const val leakcanary = "com.squareup.leakcanary:leakcanary-android:2.0"
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

    const val toothpickRuntime = "com.github.stephanenicolas.toothpick:ktp:$toothpick"
    const val toothpickSmoothie = "com.github.stephanenicolas.toothpick:smoothie:$toothpick"
    const val toothpickCompiler = "com.github.stephanenicolas.toothpick:toothpick-compiler:$toothpick"
}

object Projects {

    const val androidCore = ":android_core"
    const val domainCore = ":domain_core"
    const val domainCommon = ":domainCommon"
    const val dataCommon = ":dataCommon"

}

object Features {

    const val common = ":features:common"
    val users = Feature(":users")
    val routes = Feature(":routes")

    class Feature(relativePath: String) {
        private val path: String = ":features$relativePath"

        val api = "$path:api"
        val presentation = "$path:presentation"
        val data = "$path:data"
        val domain = "$path:domain"
    }
}
