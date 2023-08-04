plugins {
    id("com.android.application")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
    id("com.google.dagger.hilt.android")
}


android {
    namespace = "com.example.newsapp"
    compileSdk = 33

    defaultConfig {
        applicationId = "com.example.newsapp"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
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
}

dependencies {
     // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    // LiveData
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    // Annotation processor
    kapt ("androidx.lifecycle:lifecycle-compiler:2.6.1")
    // alternately - if using Java8, use the following instead of lifecycle-compiler
    implementation ("androidx.lifecycle:lifecycle-common-java8:2.6.1")
    implementation("com.google.dagger:hilt-android:2.47")
    kapt("com.google.dagger:hilt-android-compiler:2.47")
    implementation("androidx.core:core-ktx:1.10.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.code.gson:gson:2.10.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.11.0")
    testImplementation("com.squareup.okhttp3:mockwebserver:4.11.0")
    testImplementation ("com.google.truth:truth:1.1.5")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}