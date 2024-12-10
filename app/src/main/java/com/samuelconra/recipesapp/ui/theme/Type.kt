package com.samuelconra.recipesapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.samuelconra.recipesapp.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val poppinsFontFamily = FontFamily(
    Font(R.font.poppins_thin, FontWeight.Thin), // 100
    Font(R.font.poppins_extralight, FontWeight.ExtraLight), //200
    Font(R.font.poppins_light, FontWeight.Light), // 300
    Font(R.font.poppins_regular, FontWeight.Normal), // 400
    Font(R.font.poppins_medium, FontWeight.Medium), // 500
    Font(R.font.poppins_semibold, FontWeight.SemiBold), // 600
    Font(R.font.poppins_bold, FontWeight.Bold), // 700
    Font(R.font.poppins_extrabold, FontWeight.ExtraBold), // 800
    Font(R.font.poppins_black, FontWeight.Black) // 900
)

val poppinsTypo = Typography(
    titleLarge = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold,
        //lineHeight = 64.sp,
    ),
    titleMedium = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 28.sp,
        fontWeight = FontWeight.Bold,
        //lineHeight = 64.sp,
    ),
    titleSmall = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 24.sp,
        fontWeight = FontWeight.SemiBold,
        //lineHeight = 64.sp,
    ),
    bodyLarge = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 22.sp,
        fontWeight = FontWeight.Medium,
        //lineHeight = 64.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        //lineHeight = 64.sp,
    ),
    bodySmall = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 13.sp,
        fontWeight = FontWeight.Medium,
        //lineHeight = 64.sp,
    ),
    labelMedium = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Light,
        //lineHeight = 64.sp,
    )
)