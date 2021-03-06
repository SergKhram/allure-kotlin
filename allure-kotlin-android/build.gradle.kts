description = "Allure Kotlin Android Integration"

plugins {
    id("com.android.library")
    kotlin("android")
}

apply(plugin = "com.github.dcendents.android-maven")

android {
    compileSdkVersion(Versions.Android.compileSdk)
    defaultConfig {
        minSdkVersion(Versions.Android.minSdk)
        targetSdkVersion(Versions.Android.targetSdk)
        versionCode = 1
        versionName = version as String

        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    api(project(":allure-kotlin-junit4"))
    implementation(kotlin("stdlib-jdk7"))
    implementation("androidx.test.ext:junit:${Versions.Android.Test.junit}")
    implementation("androidx.test:runner:${Versions.Android.Test.runner}")
    implementation("androidx.multidex:multidex:${Versions.Android.multiDex}")
    implementation("androidx.test.uiautomator:uiautomator:${Versions.Android.Test.uiAutomator}")
}
