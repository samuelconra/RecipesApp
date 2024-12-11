package com.samuelconra.recipesapp.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.samuelconra.recipesapp.dtos.AddFavorite
import com.samuelconra.recipesapp.dtos.Auth
import com.samuelconra.recipesapp.models.Recipe
import com.samuelconra.recipesapp.services.AuthService
import com.samuelconra.recipesapp.services.RecipeService
import com.samuelconra.recipesapp.use_cases.SharedPref
import com.samuelconra.recipesapp.utils.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun RecipeScreen(innerPadding: PaddingValues, navController: NavController, recipeId: Int) {
    val scope = rememberCoroutineScope()
    var recipe by remember { mutableStateOf(Recipe())}
    val sharedPref = SharedPref(LocalContext.current)
    val userId = sharedPref.getUserIdSharedPref()
    var isFavorite by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        scope.launch(Dispatchers.IO) {
            try{
                val recipeService = Retrofit
                    .Builder()
                    .baseUrl("https://recipes-api-gyam.onrender.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(RecipeService::class.java)

                isLoading = true
                val response = recipeService.get_recipe_by_id(id = recipeId)
                recipe = response.body() ?: Recipe()
                isLoading = false
            } catch (e: Exception) {
                Log.i("Recipe Category", e.toString())
            }
        }
    }

    LaunchedEffect(key1 = true) {
        scope.launch(Dispatchers.IO) {
            try{
                val recipeService = Retrofit
                    .Builder()
                    .baseUrl("https://recipes-api-gyam.onrender.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(RecipeService::class.java)

                val response = recipeService.get_favorites(userId)
                for (recipe_fav in response.body()!!) {
                    if (recipe_fav.id == recipe.id){
                        isFavorite = true
                    }
                }
            } catch (e: Exception) {
                Log.i("Recipe Category", e.toString())
            }
        }
    }

    if (isLoading) {
        // LOADER
        Column (
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            CircularProgressIndicator()
        }
    } else {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
                .padding(horizontal = 40.dp)
                .padding(bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            // BACK AND FAVORITE ICON
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Icon(
                    imageVector = ChevronLeft,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            navController.popBackStack()
                        }
                )
                Icon(
                    imageVector = if (isFavorite) BookmarkFilled else Bookmark,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(30.dp)
                        .clickable {
                            scope.launch(Dispatchers.IO) {
                                try{
                                    val recipeService = Retrofit
                                        .Builder()
                                        .baseUrl("https://recipes-api-gyam.onrender.com/")
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build()
                                        .create(RecipeService::class.java)

                                    isLoading = true

                                    if (isFavorite){
                                        val response = recipeService.remove_favorite(user_id = userId, recipe_id = recipe.id)
                                        Log.i("Recipe Favorite", response.toString())
                                        isFavorite = false
                                    } else {
                                        val response = recipeService.add_favorite(AddFavorite(recipe_id = recipe.id, user_id = userId))
                                        Log.i("Recipe Favorite", response.toString())
                                        isFavorite = true
                                    }

                                    isLoading = false
                                } catch (e: Exception) {
                                    Log.i("Recipe Category", e.toString())
                                }
                            }
                        }
                )
            }

            // RECIPE HEADER
            Column (
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ){
                // RECIPE NAME & CATEGORY
                Column () {
                    Text(
                        text = recipe.name,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.primary,
                    )
                    Text(
                        text = recipe.category,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                    )
                }

                Text(
                    text = recipe.description,
                    style = MaterialTheme.typography.labelMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }

            AsyncImage(
                model = recipe.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .clip(RoundedCornerShape(20.dp)),
            )

            // RECIPE DETAILS
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                // Preparation time
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Timer,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Preparación:",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                    )
                    Text(
                        text = "${recipe.duration} minutos",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary,
                    )
                }

                // Difficulty
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Construction,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Dificultad:",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                    )
                    Text(
                        text = recipe.difficulty,
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary,
                    )
                }

                // Plates
                Row(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Icon(
                        imageVector = Dinner_dining,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(20.dp)
                    )
                    Text(
                        text = "Platillos:",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.primary,
                    )
                    Text(
                        text = "${recipe.plates} platos",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary,
                    )
                }
            }

            // INGREDIENTS
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                val ingredients = recipe.ingredients.split(",")

                Text(
                    text = "Ingredientes (${ingredients.size})",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.primary,
                )

                Column {
                    for (ingredient in ingredients) {
                        Text(
                            text = "- $ingredient",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.primary,
                        )
                    }
                }
            }

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(20.dp)),
                onClick = {
                    navController.navigate(Screens.RecipeStep.route + "/${recipe.id}")
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                )
            ) {
                Text(
                    text = "Empezar a Cocinar!",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.inversePrimary,
                )
            }

        }
    }
}