package com.samuelconra.recipesapp.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.samuelconra.recipesapp.models.Recipe
import com.samuelconra.recipesapp.models.Step
import com.samuelconra.recipesapp.services.RecipeService
import com.samuelconra.recipesapp.ui.components.RecipeStep
import com.samuelconra.recipesapp.ui.theme.RecipesAppTheme
import com.samuelconra.recipesapp.utils.ChevronLeft
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun RecipeStepScreen(innerPadding: PaddingValues, navController: NavController, recipeId: Int) {
    val scope = rememberCoroutineScope()
    var steps by remember { mutableStateOf<List<Step>>(emptyList()) }
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
                val response = recipeService.get_steps(recipe_id = recipeId)
                steps = response.body() ?: emptyList()
                isLoading = false
            } catch (e: Exception) {
                Log.i("Recipe Steps", e.toString())
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding)
                .padding(horizontal = 40.dp),
            verticalArrangement = Arrangement.spacedBy(40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Icon(
                    imageVector = ChevronLeft,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(40.dp)
                        .clickable {
                            navController.popBackStack()
                        }
                )
            }

            Text(
                text = "Recipe Step Screen",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
            )

            LazyColumn (
                modifier = Modifier.fillMaxWidth().weight(1f),
                verticalArrangement = Arrangement.spacedBy(40.dp),
            ){
                items(steps) { step ->
                    RecipeStep(step.step_number, step.instruction)
                }
            }
        }
    }
}