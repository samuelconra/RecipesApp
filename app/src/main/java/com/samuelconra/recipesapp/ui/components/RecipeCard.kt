package com.samuelconra.recipesapp.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.samuelconra.recipesapp.dtos.AddFavorite
import com.samuelconra.recipesapp.models.Recipe
import com.samuelconra.recipesapp.services.RecipeService
import com.samuelconra.recipesapp.use_cases.SharedPref
import com.samuelconra.recipesapp.utils.Bookmark
import com.samuelconra.recipesapp.utils.BookmarkFilled
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun RecipeCard(recipe: Recipe, onClick: () -> Unit) {
    val scope = rememberCoroutineScope()
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
                val response = recipeService.get_favorites(userId)
                for (recipe_fav in response.body()!!) {
                    if (recipe_fav.id == recipe.id){
                        isFavorite = true
                    }
                }
                isLoading = false
            } catch (e: Exception) {
                Log.i("Recipe Category", e.toString())
            }
        }
    }

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colorScheme.onPrimary)
            .clickable{
                onClick()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp)
    ){
        AsyncImage(
            model = recipe.image,
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .shadow(
                    elevation = 10.dp,
                    spotColor = Color.Black,
                    shape = RoundedCornerShape(20.dp)
                ),
            contentScale = ContentScale.Crop,
        )

        Column (
            modifier = Modifier.weight(1f),
        ){
            Text(
                text = recipe.name,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                text = "${recipe.duration} min | ${recipe.difficulty}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }

        Icon(
            imageVector = if (isFavorite) BookmarkFilled else Bookmark,
            contentDescription = null,
            modifier = Modifier
                .padding(end = 20.dp)
                .size(25.dp)
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
                },
            tint = MaterialTheme.colorScheme.onSecondary,
        )
    }
}