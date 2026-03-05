rootProject.name = "monorepo-build-release-example"

include(
    "platform",
    "common-lib",
    "modules:module1",
    "modules:module2",
    "apps:app1",
    "apps:app2"
)
