plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.kotlinfundamentals"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.kotlinfundamentals"
        minSdk = 24
        targetSdk = 36
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
        compose = true
    }
}

dependencies {

    // ========== 核心修复：Compose BOM 必须放在所有 Compose 依赖最前面 ==========
    implementation(platform(libs.androidx.compose.bom)) // 主依赖 BOM（之前漏了！）
    androidTestImplementation(platform(libs.androidx.compose.bom)) // 测试依赖 BOM

    // ========== 核心业务依赖 ==========
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // ========== 测试依赖 ==========
    testImplementation(libs.junit) // 纯 JVM 测试（src/test/java）
    androidTestImplementation(libs.androidx.junit) // 仪器化测试基础
    androidTestImplementation(libs.androidx.espresso.core) // Espresso 测试
    androidTestImplementation(libs.androidx.ui.test.junit4) // Compose UI 测试（由 BOM 管版本）
    debugImplementation(libs.androidx.ui.tooling) // Compose 预览工具
    debugImplementation(libs.androidx.ui.test.manifest) // Compose 测试清单

}