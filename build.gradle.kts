plugins {
    kotlin("jvm") version "1.9.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("dev.inmo:tgbotapi:9.2.1")
    implementation(kotlin("stdlib"))
//    implementation("io.ktor:ktor-client-core:2.3.4")
//    implementation("io.ktor:ktor-client-cio:2.3.4")
//    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.4")
//    implementation("io.ktor:ktor-client-content-negotiation:2.3.4")
//    implementation("io.ktor:ktor-client-resources:2.3.4")
//    implementation("io.ktor:ktor-client-logging:2.3.4")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}