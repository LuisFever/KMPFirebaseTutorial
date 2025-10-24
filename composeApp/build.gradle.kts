import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    // After
    alias(libs.plugins.androidApplication)
    //
    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)
//    Google Services
    alias(libs.plugins.google.services)
//    Para IOS
    alias(libs.plugins.kotlin.cocoapods)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }
    
    listOf(
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)

//            koin Android
            implementation(libs.koin.android)
//            Firebase Android
            implementation(project.dependencies.platform(libs.firebase.bom))
            implementation(libs.firebase.auth)
        }
        commonMain.dependencies {
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.androidx.lifecycle.viewmodelCompose)
            implementation(libs.androidx.lifecycle.runtimeCompose)

//            koin
            implementation(libs.koin.compose)
            implementation(libs.koin.core)
            implementation(libs.koin.compose.viewmodel)
            implementation(libs.koin.compose.viewmodel.navigation)



        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }

//    Dependencias para Firebase
    cocoapods{
        version = "1.0.0"
        summary = "Prueba KMP con firebase"
        homepage = "https://github.com/LuisFever"
        ios.deploymentTarget = "18.2" // Revisar cuanto estemos en XCODE

        framework{
            baseName = "composeApp"
            isStatic = true
        }
        pod("FirebaseCore"){
            extraOpts += listOf("-compiler-option","-fmodules")
        }
        pod("FirebaseAuth"){
            extraOpts += listOf("-compiler-option","-fmodules")
        }



    }

}

android {
    namespace = "com.luisfsc.kmpfirebasetutorial"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "com.luisfsc.kmpfirebasetutorial"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}

