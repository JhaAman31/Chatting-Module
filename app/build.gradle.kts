plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("kotlin-kapt")
}

android {
    namespace = "com.sca.chattingmodule"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.sca.chattingmodule"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.espresso.core)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation ("androidx.room:room-runtime:2.6.1")
    kapt ("androidx.room:room-compiler:2.6.1")
    implementation ("androidx.room:room-ktx:2.6.1")

    // For implementing epoxy
    implementation ("com.airbnb.android:epoxy:5.1.3")
    kapt ("com.airbnb.android:epoxy-processor:5.1.3")

    // For using circular ImageView
    implementation("de.hdodenhof:circleimageview:3.1.0")

    // For using livedata within application
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.7")

    // For using viewmodel within application
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")

    implementation("androidx.fragment:fragment-ktx:1.8.5")

    // For displaying profile and network image
    implementation("com.github.bumptech.glide:glide:4.16.0")
    kapt("com.github.bumptech.glide:compiler:4.15.1")

    // For calling API
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.12.0")

    // Socket.IO client for real-time communication
    implementation ("org.java-websocket:Java-WebSocket:1.5.3")

    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")
}
