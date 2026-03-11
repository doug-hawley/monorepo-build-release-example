monorepoProject {
    release {
        enabled = true
        tagPrefix = "notifications"
    }
}

dependencies {
    api(platform(project(":platform")))
    implementation(project(":common-lib"))
}