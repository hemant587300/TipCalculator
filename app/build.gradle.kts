plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.compose") // ✅ required for Kotlin 2.0+
}

android {
    namespace = "com.smartblind.tipcalculator"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.smartblind.tipcalculator"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.13" // ✅ Must match Compose BOM
    }

    // ❌ DO NOT include kotlinOptions here anymore if using kotlin { jvmToolchain(...) }
}

// ✅ Required for Kotlin 2.0+ to resolve JVM target errors
kotlin {
    jvmToolchain(17)
}

dependencies {
    // ✅ Jetpack Compose BOM (Platform)
    val composeBom = platform("androidx.compose:compose-bom:2024.04.01")
    implementation(composeBom)
    androidTestImplementation(composeBom)

    // ✅ Core Compose libraries
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.ui:ui-tooling-preview")

    // ✅ Debug tools
    debugImplementation("androidx.compose.ui:ui-tooling")
    // ✅ Add this line
    testImplementation("junit:junit:4.13.2")
    // ✅ Instrumentation testing support
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
