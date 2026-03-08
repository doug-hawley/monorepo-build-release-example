plugins {
    kotlin("jvm") version "1.9.24" apply false
    id("io.github.doug-hawley.monorepo-build-release-plugin") version "0.3.5"
}

monorepo {
    primaryBranch = "main"
    build {
        includeUntracked = true
        excludePatterns = listOf(
            ".*\\.md",
            ".github/.*",
            ".*\\.gitignore"
        )
    }
    release {
        globalTagPrefix = "release"
        primaryBranchScope = "minor"
    }
}

subprojects {
    repositories {
        mavenCentral()
    }

    if (name != "platform") {
        apply(plugin = "org.jetbrains.kotlin.jvm")

        dependencies {
            "testImplementation"("io.kotest:kotest-runner-junit5:5.9.1")
            "testImplementation"("io.kotest:kotest-assertions-core:5.9.1")
        }

        tasks.withType<Test> {
            useJUnitPlatform()
        }
    }
}
