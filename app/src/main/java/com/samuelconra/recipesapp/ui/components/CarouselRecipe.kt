package com.samuelconra.recipesapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.samuelconra.recipesapp.models.Recipe
import com.samuelconra.recipesapp.ui.theme.RecipesAppTheme

@Composable
fun CarouselRecipe(recipe: Recipe) {
    Box(
        modifier = Modifier.fillMaxWidth(),
    ) {
        // RECIPE IMAGE
        AsyncImage(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .shadow(
                    elevation = 10.dp,
                    spotColor = Color.Black,
                    shape = RoundedCornerShape(20.dp)
                ),
            model = ImageRequest.Builder(LocalContext.current)
                .data(recipe.image)
                .crossfade(true)
                .scale(Scale.FILL)
                .build(),
            contentDescription = "Image",
            contentScale = ContentScale.Crop,
        )

       // INFO CAROUSEL AND RECIPE
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 170.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
        ) {
            // RECIPE INFORMATION
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 40.dp)
                    .shadow(
                       elevation = 10.dp,
                       spotColor = Color.Black,
                       shape = RoundedCornerShape(15.dp)
                    )
                    .background(MaterialTheme.colorScheme.tertiary)
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
               Text(
                   text = recipe.name.uppercase(),
                   style = MaterialTheme.typography.titleSmall,
                   color = MaterialTheme.colorScheme.primary,
               )
               Text(
                   text = recipe.short_description,
                   textAlign = TextAlign.Center,
                   style = MaterialTheme.typography.bodySmall,
                   color = MaterialTheme.colorScheme.onTertiary,
               )
               Text(
                   text = "${recipe.duration} min | ${recipe.difficulty}",
                   style = MaterialTheme.typography.bodyMedium,
                   color = MaterialTheme.colorScheme.primary,
               )
            }
        }
    }
}