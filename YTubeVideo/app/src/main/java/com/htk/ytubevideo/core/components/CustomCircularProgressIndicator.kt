import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun CustomCircularProgressIndicator(
    modifier: Modifier = Modifier.width(64.dp),
    color: Color = Color.Red,
    backgroundColor: Color? = null,
    strokeWidth: Dp = 4.dp
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        CircularProgressIndicator(
            modifier = modifier,
            color = color,
            backgroundColor = backgroundColor ?: Color.Transparent,
            strokeWidth = strokeWidth
        )
    }

}