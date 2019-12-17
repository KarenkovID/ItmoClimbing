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

extra["kotlin_version"] = "1.3.50"
extra["staticAnalysisReportDir"] =  "$rootDir/build/reports/staticAnalysis"
extra["staticAnalysisDir"] =  "$rootDir/staticAnalysis"
extra["staticAnalysisEnableLint"] =  true
extra["staticAnalysisEnableDetekt"] =  true
extra["kotlin_version"] = "1.3.60-eap-25"
extra.set("kotlin_version", "1.3.60-eap-25")

apply(from = "$rootDir/dependencies.gradle.kts")

val staticAnalysisDir: String by extra
apply(from = "$staticAnalysisDir/staticAnalysis.gradle")