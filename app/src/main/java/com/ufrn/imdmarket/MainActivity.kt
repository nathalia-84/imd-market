package com.ufrn.imdmarket

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ufrn.imdmarket.ui.theme.IMDMarketTheme
import com.ufrn.imdmarket.view.login.LoginScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ufrn.imdmarket.view.Routes
import com.ufrn.imdmarket.view.create.RegisterScreen
import com.ufrn.imdmarket.view.delete.DeleteScreen
import com.ufrn.imdmarket.view.list.ListScreen
import com.ufrn.imdmarket.view.update.EditScreen
import com.ufrn.imdmarket.view.menu.MenuScreen



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IMDMarketTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = Routes.login) {
                    composable(Routes.login) {
                        LoginScreen(navController)
                    }
                    composable(Routes.menu) {
                        MenuScreen(navController)
                    }
                    composable(Routes.register) {
                        RegisterScreen()
                    }
                    composable(Routes.list) {
                        ListScreen()
                    }
                    composable(Routes.edit) {
                        EditScreen()
                    }
                    composable(Routes.delete) {
                        DeleteScreen()
                    }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    IMDMarketTheme {
        val navController = rememberNavController()
        NavHost(navController, startDestination = Routes.login) {
            composable(Routes.login) {
                LoginScreen(navController)
            }
            composable(Routes.menu) {
                MenuScreen(navController)
            }
        }
    }
}}

