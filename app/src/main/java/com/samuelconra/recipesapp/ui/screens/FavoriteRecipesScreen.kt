package com.samuelconra.recipesapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.samuelconra.recipesapp.use_cases.SharedPref
import com.samuelconra.recipesapp.utils.Logout
import com.samuelconra.recipesapp.utils.Screens

@Composable
fun FavoriteRecipesScreen(innerPadding: PaddingValues, navController: NavController) {
    val sharedPref = SharedPref(LocalContext.current)

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
                text = "Samuel",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                text = "favoritos",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
            )
        }

        val recipes = listOf(
            listOf("Ensalada de pollo", "https://images.immediate.co.uk/production/volatile/sites/30/2020/08/chorizo-mozarella-gnocchi-bake-cropped-9ab73a3.jpg?quality=90&resize=556,505"),
            listOf("Sopa", "https://some-url-to-image.jpg"),
            listOf("Postre", "https://some-url-to-image.jpg")
        )
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
                        model = recipe[1],
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
                        text = recipe[0],
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.primary,
                    )
                }
            }
        }
    }
}