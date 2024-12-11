package com.samuelconra.recipesapp.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.samuelconra.recipesapp.R
import com.samuelconra.recipesapp.models.Recipe
import com.samuelconra.recipesapp.models.User
import com.samuelconra.recipesapp.services.AuthService
import com.samuelconra.recipesapp.services.RecipeService
import com.samuelconra.recipesapp.use_cases.SharedPref
import com.samuelconra.recipesapp.utils.Logout
import com.samuelconra.recipesapp.utils.Screens
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun FavoriteRecipesScreen(innerPadding: PaddingValues, navController: NavController) {
    val sharedPref = SharedPref(LocalContext.current)
    val scope = rememberCoroutineScope()
    val userId = sharedPref.getUserIdSharedPref()
    var recipes by remember { mutableStateOf<List<Recipe>>(emptyList()) }
    var user by remember { mutableStateOf(User()) }
    var isLoading by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        scope.launch(Dispatchers.IO) {
            val retrofit = Retrofit
                .Builder()
                .baseUrl("https://recipes-api-gyam.onrender.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            try {
                isLoading = true
                val recipeService = retrofit.create(RecipeService::class.java)
                val response = recipeService.get_favorites(user_id = userId)
                withContext(Dispatchers.Main) {
                    recipes = response.body() ?: emptyList()
                    isLoading = false
                }
            } catch (e: Exception) {
                Log.i("Favorite Recipes", e.toString())
                withContext(Dispatchers.Main) {
                    isLoading = false
                }
            }

            try {
                isLoading = true
                val authService = retrofit.create(AuthService::class.java)
                val response = authService.get_user(user_id = userId)
                withContext(Dispatchers.Main) {
                    user = response.body() ?: User()
                    isLoading = false
                }
            } catch (e: Exception) {
                Log.i("User By ID", e.toString())
                withContext(Dispatchers.Main) {
                    isLoading = false
                }
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
        // MAIN COLUMN
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
        ) {
            // HEADER
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                IconButton(
                    modifier = Modifier.align(Alignment.End),
                    onClick = {
                        sharedPref.removeUserSharedPref()
                        navController.navigate(Screens.Login.route){
                            popUpTo(Screens.Login.route) { inclusive = true }
                        }
                    }
                ){
                    Icon(
                        imageVector = Logout,
                        contentDescription = "Logout",
                        modifier = Modifier.size(30.dp),
                    )
                }

                Text(
                    text = user.name,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary,
                )
                Text(
                    text = "favoritos",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary,
                )
            }

            // FAVORITE RECIPES
            LazyVerticalGrid(
                modifier = Modifier.fillMaxWidth().weight(1f),
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp),
            ){
                items(recipes){ recipe ->
                    // Card Recipe
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                            .background(MaterialTheme.colorScheme.onPrimary)
                            .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        AsyncImage(
                            model = recipe.image,
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .shadow(
                                    elevation = 10.dp,
                                    spotColor = Color.Black,
                                    shape = RoundedCornerShape(20.dp)
                                ),
                            contentScale = ContentScale.Crop
                        )

                        Text(
                            text = recipe.name,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.primary,
                        )
                    }
                }
            }
        }
    }
}