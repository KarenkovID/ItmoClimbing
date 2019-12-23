val featureRoutesRoot: String by extra

include(":featureRoutesPresentation")
include(":featureRoutes")

project(":featureRoutesPresentation").projectDir = File(featureRoutesRoot, "featureRoutesPresentation")
project(":featureRoutes").projectDir = File(featureRoutesRoot, "featureRoutes")
