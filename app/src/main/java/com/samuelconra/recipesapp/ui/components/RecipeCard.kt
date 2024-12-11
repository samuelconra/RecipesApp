package com.samuelconra.recipesapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.samuelconra.recipesapp.utils.Bookmark

@Composable
fun RecipeCard(recipe: Map<String, Any>, onClick: () -> Unit) {
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
            model = recipe["imageUrl"].toString(),
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
                text = recipe["name"].toString(),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
            )
            Text(
                text = "${recipe["time"].toString()} min | ${recipe["difficulty"].toString()}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground,
            )
        }

        Icon(
            imageVector = Bookmark,
            contentDescription = null,
            modifier = Modifier
                .padding(end = 20.dp)
                .size(25.dp),
            tint = MaterialTheme.colorScheme.onSecondary,
        )
    }
}