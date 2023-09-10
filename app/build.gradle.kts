plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("plugin.serialization") version "1.8.10"
}

android {
    namespace = "com.example.wallpapers"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.wallpapers"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Import the Compose BOM
    //implementation platform("androidx.compose:compose-bom:2023.01.00")
    ////compose navigation
    //implementation "androidx.navigation:navigation-compose:2.5.3"
    //implementation "androidx.activity:activity-compose:1.6.1"
    //implementation "androidx.compose.ui:ui"
    //implementation "androidx.compose.ui:ui-tooling-preview"
    //implementation 'androidx.compose.material3:material3'
    //implementation "androidx.core:core-ktx:1.9.0"
    //implementation "androidx.lifecycle:lifecycle-runtime-ktx:2.5.1"
    //implementation "androidx.lifecycle:lifecycle-viewmodel-compose:2.5.1"
    //// Retrofit
    //implementation "com.squareup.retrofit2:retrofit:2.9.0"
    //implementation "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0"
    ////kotlin converter
    //implementation "org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0"
    ////Coil
    //implementation "io.coil-kt:coil-compose:2.2.2"
    //testImplementation 'junit:junit:4.13.2'
    //testImplementation 'org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4'
    //androidTestImplementation 'org.junit.jupiter:junit-jupiter'
    //androidTestImplementation 'org.junit.jupiter:junit-jupiter'
    //debugImplementation "androidx.compose.ui:ui-test-manifest"
    //debugImplementation "androidx.compose.ui:ui-tooling"

    //compose navigation
    implementation ("androidx.navigation:navigation-compose:2.5.3")

    //retrofit
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")

    //coil
    implementation ("io.coil-kt:coil-compose:2.2.2")

    //json converter
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.1")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.7.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}