package com.samuelconra.recipesapp.ui.screens

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.samuelconra.recipesapp.ui.components.CarouselRecipe
import com.samuelconra.recipesapp.ui.components.RecipeCard

@Composable
fun HomeScreen(innerPadding: PaddingValues, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(MaterialTheme.colorScheme.background)
            .padding(innerPadding)
            .padding(horizontal = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(40.dp)
    ){
        // HEADER
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "hans",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.surface,
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.dp)
                    .background(MaterialTheme.colorScheme.onTertiary)
            )
        }

        // POPULAR
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "Populares",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
            )

            CarouselRecipe("Ensalada", "Clásica y deliciosa ensalada para disfrutar en casa.", "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/chorizo-mozarella-gnocchi-bake-cropped-9ab73a3.jpg?quality=90&resize=556,505",40, "Fácil", 1, 5)
        }

        // CATEGORIES
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(25.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            // Title
            Text(
                text = "Categorías",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
            )

            var selectedCategory by rememberSaveable { mutableStateOf(0) }

            // Menu categories
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
            ){
                val categories = listOf("Desayunos", "Comidas", "Cenas", "Bebidas")
                categories.forEachIndexed { index, category ->
                    Column(
                        verticalArrangement = Arrangement.spacedBy(5.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = category,
                            style = MaterialTheme.typography.bodyMedium,
                            color = if (selectedCategory == index) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onTertiary,
                            modifier = Modifier
                                .clickable {
                                    selectedCategory = index
                                }
                        )
                        Box(
                            modifier = Modifier
                                .width(30.dp)
                                .height(1.dp)
                                .background(if (selectedCategory == index) MaterialTheme.colorScheme.primary else Color.Transparent)
                        )
                    }
                }
            }

            // GET RECIPES BY CATEGORY
            val recipes = listOf(
                mapOf(
                    "name" to "Ensalada",
                    "imageUrl" to "https://www.allrecipes.com/thmb/mvO1mRRH1zTz1SvbwBCTz78CRJI=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc()/67700_RichPastaforthePoorKitchen_ddmfs_4x3_2284-220302ec8328442096df370dede357d7.jpg",
                    "time" to 40,
                    "difficulty" to "Fácil"
                ),
                mapOf(
                    "name" to "Sopa",
                    "imageUrl" to "https://cdn.loveandlemons.com/wp-content/uploads/2024/07/ratatouille.jpg",
                    "time" to 30,
                    "difficulty" to "Media"
                ),
                mapOf(
                    "name" to "Postre",
                    "imageUrl" to "https://hips.hearstapps.com/hmg-prod/images/best-soup-recipes-cheeseburger-soup-67042870d53fe.png?crop=1.00xw:1.00xh;0,0&resize=980:*",
                    "time" to 15,
                    "difficulty" to "Fácil"
                )
            )

            Column(
                modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp) // Espacio entre elementos
            ) {
                recipes.forEach { recipe ->
                    RecipeCard(
                        name = recipe["name"] as String,
                        imageUrl = recipe["imageUrl"] as String,
                        time = recipe["time"] as Int,
                        difficulty = recipe["difficulty"] as String
                    )
                }
            }

        }
    }
}