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

tasks.named("postRelease") {
    doLast {
        logger.lifecycle("[FAKE PUBLISH] :modules:module2 version ${project.version}")
    }
}
