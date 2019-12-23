val featureRoutesRoot: String by extra

include(
        ":$featureRoutesRoot:api",
        ":$featureRoutesRoot:presentation"
)

//project(":featureRoutesPresentation").projectDir = File(featureRoutesRoot, "featureRoutesPresentation")
//project(":featureRoutes").projectDir = File(featureRoutesRoot, "featureRoutes")
