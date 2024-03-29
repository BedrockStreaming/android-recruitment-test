@file:Suppress("UnstableApiUsage")

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinx.serialization)
}

android {
    namespace = "com.bedrockstreaming.brsuper"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.bedrockstreaming.brsuper"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        getByName("debug") {
            storeFile = rootDir.resolve("keystore.p12")
            storePassword = "android"
            keyAlias = "hero_key"
            keyPassword = ""
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
            signingConfig = signingConfigs.findByName("debug")
        }

        release {
            isMinifyEnabled = true
            signingConfig = signingConfigs.findByName("debug")
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
        viewBinding = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
}

dependencies {
    implementation(platform(libs.androidx.compose.bom))

    implementation(libs.core.ktx)
    implementation(libs.accompanist.material3)
    implementation(libs.appcompat)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.icons)
    implementation(libs.androidx.compose.material3.core)
    implementation(libs.androidx.compose.material3.sizeClass)
    implementation(libs.androidx.compose.ui.viewbinding)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.coil.core)
    implementation(libs.coil.compose)
    implementation(libs.koin.android)
    implementation(libs.koin.compose)
    implementation(libs.koin.core)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.cio)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.content.negotiation)
    implementation(libs.ktor.client.serialization.json)
    implementation(libs.material)
    implementation(libs.twopanelayout)

    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling.core)

    testImplementation(libs.junit)
    testImplementation(libs.mockito)
    testImplementation(libs.nhaarman.mockito.kotlin)

    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
