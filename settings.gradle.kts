pluginManagement {
    plugins {
        kotlin("jvm") version "2.0.20"
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "algorithms-data-structures"
include("lab1")
include("lab3")
include("lab4")
