monorepoProject {
    build {
        excludePatterns = listOf(".*\\.txt", "docs/.*")
    }
}

dependencies {
    api(platform(project(":platform")))
}
