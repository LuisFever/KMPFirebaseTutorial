package com.luisfsc.kmpfirebasetutorial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.luisfsc.kmpfirebasetutorial.domain.SignInWithEmail
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

@Composable
fun LoginScreen() {
    // Se obtiene el CoroutineScope para poder lanzar la corrutina en el onClick
    val scope = rememberCoroutineScope()
    val signIn: SignInWithEmail = koinInject<SignInWithEmail>()
    var email: String by remember { mutableStateOf("test@gmail.com") }
    var password: String by remember { mutableStateOf("123456") }
    var loginResult: String by remember { mutableStateOf("ESPERANDO") }

    Column(
        modifier = Modifier.fillMaxSize().safeContentPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        TextField(value = email, onValueChange = { email = it })
        TextField(value = password, onValueChange = { password = it })
        Button(onClick = {
            scope.launch {
                // Se corrige el nombre de la función 'singIn' a 'signIn'
                val result: AuthResult = signIn(email, password)
                loginResult = when (result) {
                    is AuthResult.Success -> {
                        "Éxito: " + result.user.email.orEmpty()
                    }

                    is AuthResult.Error -> {
                        "Error: " + result.message
                    }
                    // Add the 'else' branch to make the 'when' exhaustive
                    else -> {
                        "Resultado inesperado"
                    }
                }
            }
        }) {
            Text(text = "Login")
        }
        Spacer(Modifier.height(24.dp))
        Text(loginResult)
    }
}
