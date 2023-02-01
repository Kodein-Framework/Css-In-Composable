plugins {
    kotlin("multiplatform") version "1.8.0"
    id("org.jetbrains.compose") version "1.3.0"
    `maven-publish`
}

group = "org.kodein.cic"
version = "1.3.0"

allprojects {
    repositories {
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
    }
}

kotlin {
    explicitApi()

    js(IR) {
        browser()
    }

    sourceSets {
        named("jsMain") {
            dependencies {
                implementation(compose.web.core)
                implementation(compose.web.svg)
                implementation(compose.runtime)
            }
        }

        all {
            languageSettings {
                optIn("org.jetbrains.compose.web.ExperimentalComposeWebApi")
                optIn("kotlin.time.ExperimentalTime")
            }
        }
    }
}
