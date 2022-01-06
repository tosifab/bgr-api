import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "me.tosif"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.javalin:javalin:4.2.0")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

tasks{
    named<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar>("shadowJar") {
        archiveVersion.set("")
        manifest {
            attributes(mapOf("Main-Class" to "MainKt"))
        }
    }
}

tasks {
    build {
        dependsOn(shadowJar)
    }
}