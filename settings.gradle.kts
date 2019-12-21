rootProject.name="itmoclimbing"

val componentsRoot: String by extra("KommanderComponents")
apply(from = "KommanderComponents/modules.gradle.kts")
include(":app", ":domain", ":data", ":android_core")
