package com.ufrn.imdmarket.view.menu
import com.ufrn.imdmarket.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ufrn.imdmarket.view.Routes
import com.ufrn.imdmarket.view.components.Header

@Composable
fun MenuScreen(navController: NavController) {

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
            text = "O que você quer fazer?",
            style = androidx.compose.material3.MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Spacer(modifier = Modifier.height(15.dp))

        // Funções a serem executadas ao clicar nos botões
        fun onRegisterProductClick() {
            navController.navigate(Routes.register)
        }

        fun onListProductsClick() {
            navController.navigate(Routes.list)
        }

        fun onEditProductClick() {
            navController.navigate(Routes.edit)
        }
        fun onDeleteProductClick() {
            navController.navigate(Routes.delete)
        }

        // Lista de botões a serem exibidos na tela
        val buttons = listOf(
            ButtonData("Cadastrar Produtos", { onRegisterProductClick() }),
            ButtonData("Listar Produtos", { onListProductsClick() }),
            ButtonData("Alterar Produto", { onEditProductClick() }),
            ButtonData("Deletar Produto", { onDeleteProductClick() })
        )

        // Grid para exibir botões
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(buttons.size) { index ->
                val buttonData = buttons[index]
                Button(
                    onClick = buttonData.onClick,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .aspectRatio(2f)
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = buttonData.label,
                            fontSize = 14.sp,
                            modifier = Modifier.padding(8.dp),
                            maxLines = 2,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(30.dp))

        // Imagem de mercado
        Image(
            painter = painterResource(id = R.drawable.market_img),
            modifier = Modifier.size(220.dp),
            contentScale = ContentScale.FillBounds,
            contentDescription = "Market Image"
        )
    }
}
