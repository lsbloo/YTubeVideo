package com.htk.ytubevideo.core.ui

import android.annotation.SuppressLint
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.htk.ytubevideo.core.ui.fonts.GoogleFontsProvider

class AppTheme {

    private val fontFamily by lazy {
        GoogleFontsProvider.providerFamilyCosmicSans()
    }

    private val typographyApp = Typography(
        body1 = TextStyle(
            fontFamily = fontFamily, fontWeight = FontWeight.Normal, fontSize = 12.sp
        ),
        body2 = TextStyle(
            fontFamily = fontFamily,
            fontWeight = FontWeight.Bold,
            letterSpacing = 2.sp,
        ),
        h4 = TextStyle(
            fontFamily = fontFamily, fontWeight = FontWeight.SemiBold/*...*/
        ),
    )

    @SuppressLint("NotConstructor")
    @Composable
    fun AppTheme(content: @Composable () -> Unit) {
        MaterialTheme(
            typography = typographyApp
        ) {

            content()
        }
    }
}