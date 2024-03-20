package com.htk.ytubevideo.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.htk.ytubevideo.core.ui.color.YTubeColors
import com.htk.ytubevideo.core.ui.extensions.modifierCustomButton

@Composable
fun CustomButton(onClick: () -> Unit, nameButton: String) {

    val interactionSource = remember {
        MutableInteractionSource()
    }

    val isPressedButton by interactionSource.collectIsPressedAsState()

    val colorButton = if (isPressedButton) {
        YTubeColors.color(YTubeColors.DIMGRAY_COLOR)
    } else {
        Color.Transparent
    }

    Button(
        onClick = {
            onClick.invoke()
        },
        interactionSource = interactionSource,
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorButton,

            ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 8.dp
        ),
        border = BorderStroke(2.dp, color = YTubeColors.color(YTubeColors.DIMGRAY_COLOR)),
        modifier = Modifier.modifierCustomButton()
    ) {
        TextView(text = nameButton, color = Color.White, fontSize = 18.sp)
    }
}