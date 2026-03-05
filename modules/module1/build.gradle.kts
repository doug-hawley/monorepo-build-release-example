monorepoProject {
    release {
        enabled = true
    }
}

dependencies {
    api(platform(project(":platform")))
    implementation(project(":common-lib"))
}

tasks.named("postRelease") {
    doLast {
        logger.lifecycle("[FAKE PUBLISH] :modules:module1 version ${project.version}")
    }
}
