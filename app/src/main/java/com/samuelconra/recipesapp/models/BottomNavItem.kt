package com.samuelconra.recipesapp.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.rounded.Home
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.samuelconra.recipesapp.utils.BookmarkFilled
import com.samuelconra.recipesapp.utils.Screens

data class BottomNavItem (val title: String, val icon: ImageVector,val route: String) {
    companion object {
        val items = listOf(
            BottomNavItem(
                title = "Home",
                icon = Icons.Rounded.Home,
                route = Screens.Home.route
            ),
            BottomNavItem(
                title = "Favorites",
                icon = BookmarkFilled,
                route = Screens.Favorites.route
            ),
        )
    }
}