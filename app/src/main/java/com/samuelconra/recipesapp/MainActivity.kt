package com.samuelconra.recipesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.samuelconra.recipesapp.models.BottomNavItem
import com.samuelconra.recipesapp.ui.components.BottomNavigationView
import com.samuelconra.recipesapp.ui.screens.HomeScreen
import com.samuelconra.recipesapp.ui.screens.LoginScreen
import com.samuelconra.recipesapp.ui.screens.RecipeScreen
import com.samuelconra.recipesapp.ui.theme.RecipesAppTheme
import com.samuelconra.recipesapp.utils.Screens

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val selectedItem = rememberSaveable { mutableIntStateOf(0) }
            RecipesAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = { BottomNavigationView(navController, selectedItem) }
                ){ innerPadding ->
                    NavHost(navController = navController, startDestination = Screens.Home.route) {
                        composable(route = Screens.Login.route) {
                            // TO DO
                        }
                        composable(route = Screens.SingUp.route) {
                            // TO DO
                        }
                        composable(route = Screens.Home.route) {
                            HomeScreen(innerPadding, navController)
                        }
                        composable(route = Screens.Favorites.route) {
                            LoginScreen(innerPadding, navController)
                        }
                        composable(route = Screens.Login.route) {
                            // TO DO
                        }
                        composable(
                            route = Screens.Recipe.route + "/{recipeId}",
                            arguments = listOf(
                                navArgument("recipeId") {
                                    type = NavType.IntType
                                }
                            )
                        ){
                            val recipeId = it.arguments?.getInt("recipeId") ?: 0
                            RecipeScreen(innerPadding, navController,recipeId)
                        }
                        composable(route = Screens.RecipeStep.route) {
                            // TO DO
                        }
                    }
                }
            }
        }
    }
}