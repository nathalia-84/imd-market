package com.ufrn.imdmarket.view.delete

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ufrn.imdmarket.view.components.Header

@Composable
fun DeleteScreen() {

    val context = LocalContext.current

    // Estado para o campo de texto
    var productCode by remember { mutableStateOf("") }

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
            text = "Deletar Produto",
            style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterStart
        ){
            Text(
                text = "Código do Produto",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }

        OutlinedTextField(
            value = productCode,
            onValueChange = { productCode = it },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(16.dp))


        // Botão de Cadastro
        Button(
            onClick = {
                if (productCode.isBlank()) {
                    // Exibir Toast caso falte algum campo
                    Toast.makeText(context, "Por favor, informe o código do produto", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    // Persistir os dados
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Deletar Produto")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    DeleteScreen()
}