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