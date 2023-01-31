plugins {
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("plugin.spring") version "1.6.21"

    kotlin("jvm") version "1.8.0"
    id("org.openjfx.javafxplugin") version "0.0.13-SNAPSHOT"
    //application
}

group = "org.cameek"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {


    implementation("org.apache.commons:commons-lang3:3.12.0")

//    implementation("org.jetbrains.kotlin:kotlin-reflect")
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

    implementation("org.springframework.boot:spring-boot-devtools")
    implementation("org.springframework.boot:spring-boot-starter")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("com.github.pgreze:kotlin-process:1.4.1")

    // https://mvnrepository.com/artifact/no.tornado/tornadofx
    implementation("no.tornado:tornadofx:1.7.20")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

//application {
//    mainClass.set("MainKt")
//}

javafx {
    version = "19.0.2.1"
    modules = listOf("javafx.controls", "javafx.graphics")
}