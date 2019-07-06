plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.40")
}

repositories {
    mavenCentral()
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

val junitVersion by extra("5.4.2")

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")

    testImplementation("org.assertj:assertj-core:3.12.2")
    testImplementation("io.mockk:mockk:1.9.3")
}