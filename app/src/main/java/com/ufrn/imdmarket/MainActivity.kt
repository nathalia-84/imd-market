package com.ufrn.imdmarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ufrn.imdmarket.db.AppDatabase
import com.ufrn.imdmarket.ui.theme.IMDMarketTheme
import com.ufrn.imdmarket.view.Routes
import com.ufrn.imdmarket.view.create.RegisterScreen
import com.ufrn.imdmarket.view.delete.DeleteScreen
import com.ufrn.imdmarket.view.list.ListScreen
import com.ufrn.imdmarket.view.login.LoginScreen
import com.ufrn.imdmarket.view.menu.MenuScreen
import com.ufrn.imdmarket.view.update.EditScreen
import com.ufrn.imdmarket.viewmodel.AppViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializa o banco de dados e DAO
        val db = AppDatabase.getInstance(applicationContext) // Use applicationContext
        val productDao = db.productDao()

        // Inicializa o ViewModel
        val viewModel = AppViewModel(productDao)

        enableEdgeToEdge()
        setContent {
            IMDMarketTheme {
                //Inicializa o navController
                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background) {
                    NavHost(navController, startDestination = Routes.login) {
                        composable(Routes.login) {
                            LoginScreen(navController)
                        }
                        composable(Routes.menu) {
                            MenuScreen(navController)
                        }
                        composable(Routes.register) {
                            RegisterScreen(viewModel)
                        }
                        composable(Routes.list) {
                            ListScreen(viewModel, navController)
                        }
                        composable(Routes.edit) {
                            EditScreen(viewModel)
                        }
                        composable(Routes.delete) {
                            DeleteScreen(viewModel)
                        }
                }
                }
            }
        }
    }
}


