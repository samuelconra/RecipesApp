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
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.samuelconra.recipesapp.dtos.Auth
import com.samuelconra.recipesapp.services.AuthService
import com.samuelconra.recipesapp.services.RecipeService
import com.samuelconra.recipesapp.ui.components.CarouselRecipe
import com.samuelconra.recipesapp.ui.components.RecipeCard
import com.samuelconra.recipesapp.use_cases.SharedPref
import com.samuelconra.recipesapp.utils.Screens
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun HomeScreen(innerPadding: PaddingValues, navController: NavController) {
    val scope = rememberCoroutineScope()
    val sharedPref = SharedPref(LocalContext.current)
    val categories = listOf("Desayunos", "Comidas", "Cenas", "Bebidas")
    var recipes by remember { mutableStateOf<List<Recipe>>(emptyList()) }

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

            // API GET RECIPES BY CATEGORY
            LaunchedEffect(selectedCategory) {
                scope.launch(Dispatchers.IO) {
                    try {
                        val authService = Retrofit
                            .Builder()
                            .baseUrl("https://recipes-api-gyam.onrender.com/")
                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                            .create(RecipeService::class.java)

                        val response = authService.get_recipes_by_category(categories[selectedCategory])
                        withContext(Dispatchers.Main) {
                            val recipes = response
                        }
                    } catch (e: Exception) {

                    }
                }
            }

            // RECIPES BY CATEGORY
            Column(
                modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp) // Espacio entre elementos
            ) {
                recipes.forEach { recipe ->
                    RecipeCard(recipe){
                        navController.navigate(Screens.Recipe.route + "/${recipe["id"]}")
                    }
                }
            }
        }
    }
}