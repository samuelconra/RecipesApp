package com.samuelconra.recipesapp.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    background = DarkModeBackgroundColor,
    primary = Color.White,
    tertiary = DarkModeGray,
    onBackground = DarkModeGray2,
    onPrimary = DarkModeGray3,
    onSecondary = DarkModeGray4,
    onTertiary = CustomGray2,
    surface = CustomBackgroundColor,
    surfaceVariant = CustomWhiteOpacity,
    primaryContainer = CustomBlackOpacity2,
    inversePrimary = Color.Black,
)

private val LightColorScheme = lightColorScheme(
    background = CustomBackgroundColor,
    primary = Color.Black,
    tertiary = Color.White,
    onBackground = CustomDarkGray,
    onPrimary = CustomLightGray,
    onSecondary = CustomGray,
    onTertiary = CustomGray2,
    surface = CustomRed,
    surfaceVariant = CustomBlackOpacity,
    primaryContainer = CustomBlackOpacity2,
    inversePrimary = Color.White,
)

@Composable
fun RecipesAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = poppinsTypo,
        content = content
    )
}