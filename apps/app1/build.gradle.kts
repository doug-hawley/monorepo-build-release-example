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

tasks.named("postRelease") {
    doLast {
        logger.lifecycle("[FAKE PUBLISH] :apps:app1 version ${project.version}")
    }
}
