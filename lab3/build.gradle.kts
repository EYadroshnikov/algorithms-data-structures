import org.gradle.kotlin.dsl.runtimeClasspath
import kotlin.text.set

plugins {
    kotlin("jvm")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(20)
}

tasks.register<JavaExec>("runLab3") {
    group = "application"
    description = "Запуск основного кода лабораторной работы 3"
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("lab3.MainKt")
}