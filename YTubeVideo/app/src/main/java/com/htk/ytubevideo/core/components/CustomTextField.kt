package com.htk.ytubevideo.core.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.htk.ytubevideo.core.ui.color.YTubeColors


@Composable
fun CustomTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: @Composable() (() -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done
) {
    TextField(
        value = value,
        onValueChange = { text ->
            onValueChange.invoke(text)
        },
        label = {
            label?.invoke()
        },
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            backgroundColor = YTubeColors.color(YTubeColors.DIMGRAY_COLOR),
            placeholderColor = Color.Black,
            cursorColor = Color.Transparent,
            focusedLabelColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent

        ),
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.None,
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        shape = RoundedCornerShape(size = 8.dp),
        modifier = modifier
    )
}