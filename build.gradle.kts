// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
    }
    dependencies {
        classpath(BuildPlugins.androidGradlePlugin)
        classpath(BuildPlugins.kotlinGradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven("https://dl.bintray.com/kotlin/kotlin-eap")
    }
}
//subprojects {
//
//    // BasePlugin is the common superclass of the AppPlugin and LibraryPlugin which are the plugin classes that "com.android.application" and "com.android.library" apply
//    plugins.withType(BasePlugin::class.java) {
//
//        // BaseExtension is the common superclass of the AppExtension and LibraryExtension which are the extension classes registered by the two plugins to the name "android"
//        configure<com.android.build.gradle.BaseExtension> {
//
//            // This block is typed correctly
//            compileSdkVersion(AndroidSdk.compile)
//
//            defaultConfig {
//                minSdkVersion(AndroidSdk.min)
//            }
//
//            sourceSets {
//                getByName("main").java.srcDirs("src/main/kotlin")
//            }
//        }
//    }
//}
//subprojects { subproject ->
//    apply(plugin = BuildPlugins.androidApplication)
//    android {
//        compileSdkVersion(AndroidSdk.compile)
//
//        defaultConfig {
//            minSdkVersion(AndroidSdk.min)
//        }
//
//        sourceSets {
//            getByName("main").java.srcDirs("src/main/kotlin")
//        }
//
//    }
//}

tasks.register<Delete>("clean").configure {
    delete(rootProject.buildDir)
 }

extra["staticAnalysisReportDir"] =  "$rootDir/build/reports/staticAnalysis"
extra["staticAnalysisDir"] =  "$rootDir/staticAnalysis"
extra["staticAnalysisEnableLint"] =  true
extra["staticAnalysisEnableDetekt"] =  true
extra["kotlin_version"] = "kotlinVersion"

val staticAnalysisDir: String by extra
apply(from = "$staticAnalysisDir/staticAnalysis.gradle")