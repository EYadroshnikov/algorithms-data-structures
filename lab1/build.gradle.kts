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
    implementation(kotlin("stdlib"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(20)
    jvmToolchain(8)
}

tasks.register<JavaExec>("runLab1") {
    group = "application"
    description = "Запуск основного кода лабораторной работы 1"
    classpath = sourceSets["main"].runtimeClasspath
    mainClass.set("lab1.MainKt")
}