plugins {
    kotlin("jvm") version "2.1.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))

    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.1.10")
    testImplementation("org.slf4j:slf4j-simple:1.7.26")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(23)
}