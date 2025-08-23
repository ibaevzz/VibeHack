plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "ru.ibaevzz.vibehack"
    compileSdk = 35

    defaultConfig {
        applicationId = "ru.ibaevzz.vibehack"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
    }

    buildFeatures {
        compose = true
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        @Suppress("DEPRECATION")
        jvmTarget = "11"
    }
}

dependencies {
    //Android core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.lifecycle.runtime.ktx)

    //Jetpack Compose
    implementation(platform(libs.compose.bom))
    implementation(libs.compose.material3)
    implementation(libs.compose.foundation)
    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    debugImplementation(libs.compose.ui.tooling)

    //AndroidX Activity & ViewModel
    implementation(libs.activity.compose)
    implementation(libs.lifecycle.viewmodel.compose)

    //Kotlin Coroutines
    implementation(libs.kotlinx.coroutines.android)

    //Dependency Injection
    implementation(libs.dagger)
    ksp(libs.dagger.compiler)

    //Room (Database)
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    //Networking
    implementation(libs.retrofit)
    implementation(libs.retrofit.mock)
    implementation(libs.okhttp)
    implementation(libs.gson)

    //Navigation
    implementation(libs.cicerone)

    //Kotlin Utilities
    implementation(libs.kotlin.result)
}