plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
    kotlin("plugin.serialization") version "1.9.23"
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.9")
    implementation("android.arch.core:core-testing:1.1.1")
    compileOnly("com.github.skydoves:compose-stable-marker:1.0.3")
}