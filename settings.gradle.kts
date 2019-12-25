rootProject.name="itmoclimbing"

val componentsRoot: String by extra("KommanderComponents")
val featureRoutesRoot: String by extra("featureRoutes")
val featureUsersRoot: String by extra("featureUsers")

apply(from = "$componentsRoot/modules.gradle.kts")
apply(from = "$featureRoutesRoot/modules.gradle.kts")
apply(from = "$featureUsersRoot/modules.gradle.kts")
include(
        ":app",
        ":domainCommon",
        ":dataCommon",
        ":android_core",
        ":featureRoutes:api",
        ":featureUsers:api",
        ":presentationCommon",
        ":featuresCommon"
)
