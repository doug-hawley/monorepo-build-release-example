monorepoProject {
    release {
        enabled = true
    }
}

dependencies {
    api(platform(project(":platform")))
    implementation(project(":modules:module1"))
    implementation(project(":modules:module2"))
}