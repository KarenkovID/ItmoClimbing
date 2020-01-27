import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("java-library")
    id("kotlin")
    id("kotlin-kapt")
}

dependencies {
    implementation(kotlin("stdlib", KotlinCompilerVersion.VERSION))

    implementation(DI.toothpickRuntime)
    implementation(DI.toothpickSmoothie)
    implementation(Libraries.moshi)
    kapt(Libraries.moshiCompiler)
    kapt(DI.toothpickCompiler)

    implementation(Libraries.cicerone)

    implementation(Libraries.rxJava)
    implementation(Libraries.rxKotlin)
}
