rootProject.name="itmoclimbing"

val componentsRoot: String by extra("KommanderComponents")

include(
        ":app",
        ":domainCommon",
        ":dataCommon",
        ":android",
        ":features:common"
)

apply(from = "$componentsRoot/modules.gradle.kts")
apply(from = "features/routes/modules.gradle.kts")
apply(from = "features/users/modules.gradle.kts")

