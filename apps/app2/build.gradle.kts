monorepoProject {
    build {
        excludePatterns = listOf(".*\\.properties", "config/.*")
    }
    release {
        enabled = true
    }
}

dependencies {
    api(platform(project(":platform")))
    implementation(project(":modules:module2"))
}