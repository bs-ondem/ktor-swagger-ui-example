
val kotlin_version: String by project
val ktor_swagger_version: String by project
val schema_kenerator: String by project
val ktor_version: String by project
val logback_version: String by project
val swagger_parser: String by project

plugins {
    kotlin("jvm") version "2.0.0"
    id("io.ktor.plugin") version "2.3.12"
    id("org.jetbrains.kotlin.plugin.serialization") version "2.0.0"
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("com.example.ApplicationKt")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    // Testing custom schema generation
    implementation("io.github.smiley4:schema-kenerator-core:$schema_kenerator")
    implementation("io.github.smiley4:schema-kenerator-reflection:$schema_kenerator")
    implementation("io.github.smiley4:schema-kenerator-serialization:$schema_kenerator")
    implementation("io.github.smiley4:schema-kenerator-jsonschema:$schema_kenerator")
    implementation("io.github.smiley4:schema-kenerator-swagger:$schema_kenerator")
    implementation("io.swagger.parser.v3:swagger-parser:$swagger_parser")

    // KTor dependencies
    implementation("io.github.smiley4:ktor-swagger-ui:$ktor_swagger_version")
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")

    implementation("ch.qos.logback:logback-classic:$logback_version")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")
}
