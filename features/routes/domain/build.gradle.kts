plugins {
    id(BuildPlugins.kotlin)
    id(BuildPlugins.kotlinKapt)
}

dependencies {
    implementation(Libraries.kotlinStdLib)
    testImplementation(TestLibraries.junit4)

    implementation(project(Projects.domainCore))
    implementation(project(Projects.domainCommon))

    implementation(DI.toothpickRuntime)
    implementation(DI.toothpickSmoothie)
    kapt(DI.toothpickCompiler)

    implementation(Libraries.rxJava)
    implementation(Libraries.rxKotlin)
}
