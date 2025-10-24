package com.luisfsc.kmpfirebasetutorial

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.luisfsc.kmpfirebasetutorial.di.authModule
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.dsl.koinApplication

@Composable
@Preview
fun App() {
    KoinApplication(application = {modules(
        platformModule, authModule
    )}){
//        Box(Modifier.fillMaxSize().background(Color.Red), contentAlignment = Alignment.Center){
//            Text("Hola, soy LuisFSC", fontSize = 45.sp, color = Color.White)
//        }
        LoginScreen()
    }
}