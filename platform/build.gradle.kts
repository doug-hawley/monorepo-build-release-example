plugins {
    `java-platform`
}

javaPlatform {
    allowDependencies()
}

dependencies {
    constraints {
        api("org.jetbrains.kotlin:kotlin-stdlib:1.9.24")
        api("io.kotest:kotest-runner-junit5:5.9.1")
        api("io.kotest:kotest-assertions-core:5.9.1")
    }
}
