// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    extra["staticAnalysisReportDir"] =  "$rootDir/build/reports/staticAnalysis"
    extra["staticAnalysisDir"] =  "$rootDir/staticAnalysis"
    extra["staticAnalysisEnableLint"] =  true
    extra["staticAnalysisEnableDetekt"] =  true
    extra["kotlin_version"] = "kotlinVersion"

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

plugins {
    id("io.gitlab.arturbosch.detekt").version("1.4.0")
}

val staticAnalysisDir: String by extra
val staticAnalysisDetektBaseline: String by extra
val staticAnalysisReportDir: String by extra

val detektAll by tasks.registering(io.gitlab.arturbosch.detekt.Detekt::class) {
    description = "Runs over whole code base without the starting overhead for each module."
    parallel = true
    setSource(files(projectDir))
    include("**/*.kt")
    exclude("**/resources/**", "**/build/**", "buildSrc/**")
    config.setFrom(files("$staticAnalysisDir/detekt-config.yml"))
    ignoreFailures = true
    autoCorrect = true

    reports {
        xml {
            enabled = true
            destination = file("$staticAnalysisReportDir/report_detekt.xml")
        }
        html {
            enabled = false
        }
    }
}

tasks {
    withType<io.gitlab.arturbosch.detekt.Detekt> {
        // Target version of the generated JVM bytecode. It is used for type resolution.
        this.jvmTarget = "1.8"
    }
}

val detektProjectBaseline by tasks.registering(io.gitlab.arturbosch.detekt.DetektCreateBaselineTask::class) {
    description = "Overrides current baseline."
    setSource(files(projectDir))
    include("**/*.kt")
    exclude("**/resources/**", "**/build/**", "buildSrc/**")
    config.setFrom(files("$staticAnalysisDir/detekt-config.yml"))
}

dependencies {
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:1.4.0")
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

apply(from = "$staticAnalysisDir/staticAnalysis.gradle")