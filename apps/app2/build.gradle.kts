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

tasks.named("postRelease") {
    doLast {
        logger.lifecycle("[FAKE PUBLISH] :apps:app2 version ${project.version}")
    }
}
