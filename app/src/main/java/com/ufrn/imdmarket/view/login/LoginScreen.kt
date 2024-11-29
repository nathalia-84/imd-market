package com.ufrn.imdmarket.view.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.ufrn.imdmarket.view.Routes
import com.ufrn.imdmarket.view.components.Header

@Composable
fun LoginScreen(navController: NavController) {
    // Estados para os campos de texto
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    // Header do aplicativo
    Header(title = "IMDMarket")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        // Título da Página
        Text(
            text = "Login",
            style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        // Campo de E-mail
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("E-mail") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Campo de Senha
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Mensagem de erro ao não digitar info de login
        if (showError) {
            Text(
                text = "E-mail ou senha inválidos.",
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Botão de Login
        Button(
            onClick = {
                if (email == "admin" && password == "admin") {
                    navController.navigate(Routes.menu)
                } else {
                    showError = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Entrar")
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Texto clicável "Esqueci minha senha"
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Esqueci minha senha",
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.primary),
                modifier = Modifier.clickable { /*REdirecionar para a tela de recuperação de senha*/ }
            )
        }
    }
}



