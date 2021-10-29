import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
}
val privateKey: String = gradleLocalProperties(rootDir).getProperty("privateKey")
val publicKey: String = gradleLocalProperties(rootDir).getProperty("publicKey")
dependencies {
    implementation(project(":shared"))
    //Picasso
    implementation("com.squareup.picasso:picasso:2.71828")
    // Kotlin Coroutines
    val coroutinesVersion = "1.5.0"
    implementation("org.jetbrains.kotlinx:kotlinx-coroutine s-core:$coroutinesVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutine s-android:$coroutinesVersion")
    val lifecycle_version = "2.4.0-alpha03"
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")
    // Retrofit
    val retrofitVersion = "2.9.0"
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation ("androidx.core:core-ktx:1.6.0")
    implementation ("androidx.appcompat:appcompat:1.3.1")
    implementation ("com.google.android.material:material:1.4.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.0")
    implementation ("androidx.recyclerview:recyclerview:1.2.1")
    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.3")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.4.0")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "ar.edu.unlam.marvelmultiplataforma.android"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("debug"){
            buildConfigField("String", "PRIVATE_KEY", "\"" + privateKey + "\"")
            buildConfigField("String", "PUBLIC_KEY", "\"" + publicKey + "\"")
        }
        getByName("release") {
            isMinifyEnabled = false
        }
        buildFeatures{
            viewBinding = true
        }
    }
}