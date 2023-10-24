import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "2.0.255-SNAPSHOT"
    id("org.jetbrains.kotlin.plugin.formver").version("2.0.255-SNAPSHOT")

    // Apply the java-library plugin for API and implementation separation.
    `java-library`
}

formver {
    conversionTargetsSelection("all_targets")
    verificationTargetsSelection("all_targets")
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-formver-compiler-plugin.annotations:2.0.255-SNAPSHOT")
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
        languageVersion.set(KotlinVersion.KOTLIN_2_0)
    }
    kotlinDaemonJvmArgs = listOf("-Xss30m")
}

