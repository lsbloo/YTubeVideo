package com.htk.ytubevideo.core.ui.fonts

import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.googlefonts.Font
import com.htk.ytubevideo.R

object GoogleFontsProvider {

    private val provider by lazy {
        GoogleFont.Provider(
            providerAuthority = "com.google.android.gms.fonts",
            providerPackage = "com.google.android.gms",
            certificates = R.array.com_google_android_gms_fonts_certs
        )
    }

    fun providerFamilyCosmicSans(): FontFamily {
        val fontName = GoogleFont("Comic Neue")

        return FontFamily(
            Font(
                googleFont = fontName,
                fontProvider = provider,
                weight = FontWeight.Normal,
                style = FontStyle.Normal
            )
        )
    }
}