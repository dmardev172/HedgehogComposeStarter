@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
//    alias(libs.plugins.androidApplication)
//    alias(libs.plugins.kotlinAndroid)
    id("com.android.application") // version "8.10.0" // lub nowsze
//    kotlin("android") version "2.0.21" // 2.0
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "pl.dmardev172.hedgefirstapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "pl.dmardev172.hedgefirstapp"
        minSdk = 23 //24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString() //"17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
        // Dla Kotlin 2.0 NIE ustawiamy composeCompilerVersion ręcznie
        // Compose Compiler jest powiązany z Kotlinem (K2)
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(platform(libs.compose.bom))
//    implementation(platform("androidx.compose:compose-bom:2024.10.00"))
    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
//    implementation("androidx.activity:activity-compose:1.9.2")
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
//    implementation("androidx.navigation3:navigation3-runtime-jvmstubs:1.0.0-alpha07") //Android Gradle plugin 8.9.1
//    implementation("androidx.navigation3:navigation3-ui-jvmstubs:1.0.0-alpha07") //1.0.1
    implementation("androidx.navigation:navigation-compose:2.8.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.7") // 2.7.0  2.9.2 ??

    // Tests
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.test.ext.junit)
//    androidTestImplementation(libs.espresso.core)
//    androidTestImplementation(platform(libs.compose.bom))
//    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
}