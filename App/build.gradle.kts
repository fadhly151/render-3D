plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization")
}

android {
    namespace = "com.renderinterior.app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.renderinterior.app"
        minSdk = 26 // Filament butuh OpenGL ES 3.1+/Vulkan yang stabil mulai Android 8.0
        targetSdk = 35
        versionCode = 1
        versionName = "0.1.0-mvp"

        // Ganti sesuai URL backend produksi -- lihat catatan di README
        buildConfigField("String", "API_BASE_URL", "\"https://api.namadomain.com/\"")
    }

    buildTypes {
        debug {
            buildConfigField("String", "API_BASE_URL", "\"http://10.0.2.2:4000/\"") // localhost dari emulator Android
        }
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // --- Filament: render engine real-time (preview) ---
    // filament-android = engine inti; gltfio-android = loader glTF/GLB;
    // filament-utils-android = helper kamera/manipulator (dipakai di FilamentSceneManager)
    implementation("com.google.android.filament:filament-android:1.51.5")
    implementation("com.google.android.filament:gltfio-android:1.51.5")
    implementation("com.google.android.filament:filament-utils-android:1.51.5")

    // --- Jetpack Compose ---
    implementation(platform("androidx.compose:compose-bom:2024.09.03"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.compose.material:material-icons-core")
    implementation("androidx.activity:activity-compose:1.9.2")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.6")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.6")
    implementation("androidx.navigation:navigation-compose:2.8.1")
    debugImplementation("androidx.compose.ui:ui-tooling")

    // --- Networking ---
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-kotlinx-serialization:2.11.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

    // --- Penyimpanan token/preference lokal ---
    implementation("androidx.datastore:datastore-preferences:1.1.1")

    // --- Load gambar (thumbnail katalog, hasil render) ---
    implementation("io.coil-kt:coil-compose:2.7.0")

    // --- Coroutines ---
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.6")
}
