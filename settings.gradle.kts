rootProject.name="itmoclimbing"

val componentsRoot: String by extra("KommanderComponents")

apply(from = "$componentsRoot/modules.gradle.kts")
apply(from = "features/routes/modules.gradle.kts")
apply(from = "features/users/modules.gradle.kts")
include(
        ":app",
        ":domainCommon",
        ":dataCommon",
        ":android_core",
        ":presentationCommon",
        ":features:common"
)
