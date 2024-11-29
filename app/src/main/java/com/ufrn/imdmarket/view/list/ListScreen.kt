package com.ufrn.imdmarket.view.list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ufrn.imdmarket.view.components.Header

@Composable
fun ListScreen() {

    // Header do aplicativo
    Header(title = "IMDMarket")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp)
            .padding(top = 50.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Título da Página
        Text(
            text = "Lista de Produtos",
            style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        // Lista de produtos a serem exibidos na tela
        val products = listOf(
            "Produto 01",
            "Produto 02",
            "Produto 03",
            "Produto 04",
            "Produto 05"
        )

        // Grid para exibir produtos
        LazyVerticalGrid(
            columns = GridCells.Fixed(1),
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(products.size) { index ->
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Text(
                        text = products[index],
                        fontSize = 14.sp,
                        modifier = Modifier.padding(8.dp),
                        maxLines = 2,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    ListScreen()
}