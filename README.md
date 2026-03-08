# Monorepo Build & Release Example

A working example demonstrating the [monorepo-build-release-plugin](https://github.com/doug-hawley/monorepo-build-release-plugin) for Gradle.

## Module Structure

```
platform/          → java-platform BOM (no release)
common-lib/        → shared utilities (no release)
modules/module1/   → user service (release enabled)
modules/module2/   → notification service (release enabled, custom tagPrefix)
apps/app1/         → depends on module1 + module2 (release enabled, postRelease hook)
apps/app2/         → depends on module2 (release enabled)
```

## Dependency Graph

```
common-lib ←── module1 ←── app1
           ←── module2 ←── app1
                       ←── app2
```

Transitive detection: a change to `common-lib` triggers builds for module1, module2, app1, and app2.

## Plugin Features Demonstrated

| Feature | Location |
|---|---|
| `primaryBranch`, `includeUntracked` | Root `build.gradle.kts` |
| Global `excludePatterns` | Root `build.gradle.kts` |
| Per-project `excludePatterns` | `common-lib`, `apps/app2` |
| `globalTagPrefix`, `primaryBranchScope` | Root `build.gradle.kts` |
| Release opt-in | module1, module2, app1, app2 |
| Custom `tagPrefix` | module2 (`"notifications"`) |
| `postRelease` hook | app1 |

## CI/CD Workflows

| Workflow | Trigger | Tasks |
|---|---|---|
| PR Validation | Pull request to `main` | `printChangedProjects`, `buildChangedProjects` |
| Post-Merge Build | Push to `main` | `printChangedProjects`, `buildChangedProjectsAndCreateReleaseBranches` |
| Release | Push to `release/*/v*.x` | `:subproject:build`, `:subproject:release` |

## Getting Started

```bash
# Clone the repository
git clone https://github.com/doug-hawley/monorepo-build-release-example.git
cd monorepo-build-release-example

# Build all modules
./gradlew build

# See which projects changed (compared to main)
./gradlew printChangedProjects

# Build only changed projects
./gradlew buildChangedProjects
```

## Release Prefix Mapping

Because module2 uses a custom `tagPrefix = "notifications"`, the release branch
`release/notifications/v0.1.x` cannot be naively reversed to find the Gradle path
`:modules:module2`. The `.github/release-prefix-map.json` file provides this mapping
for the release workflow.
