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
import com.samuelconra.recipesapp.ui.theme.RecipesAppTheme

@Composable
fun CarouselRecipe(name: String, description: String, imageUrl: String, time: Int, difficulty: String, index: Int, carouselSize: Int) {
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
                .data(imageUrl)
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
                   text = name.uppercase(),
                   style = MaterialTheme.typography.titleSmall,
                   color = MaterialTheme.colorScheme.primary,
               )
               Text(
                   text = description,
                   textAlign = TextAlign.Center,
                   style = MaterialTheme.typography.bodySmall,
                   color = MaterialTheme.colorScheme.onTertiary,
               )
               Text(
                   text = "$time MIN | $difficulty",
                   style = MaterialTheme.typography.bodyMedium,
                   color = MaterialTheme.colorScheme.primary,
               )
            }

            // DOTS CAROUSEL
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                for (i in 0..carouselSize){
                    if (i == index){
                        Box(
                            modifier = Modifier
                                .size(9.dp)
                                .clip(RoundedCornerShape((4.5).dp))
                                .background(MaterialTheme.colorScheme.primary)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    } else {
                        Box(
                            modifier = Modifier
                                .size(7.dp)
                                .clip(RoundedCornerShape((3.5).dp))
                                .background(MaterialTheme.colorScheme.surfaceVariant)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                    }
                }
            }
            }
    }
}

@Composable
@Preview(
    showSystemUi = true,
    showBackground = true
)
fun ItemCarouselPreview() {
    RecipesAppTheme {
        CarouselRecipe("Ensalada", "La descripción del platillo", "",40, "Fácil", 1, 5 )
    }
}