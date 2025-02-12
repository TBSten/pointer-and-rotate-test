package your.projectPackage.app

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UnexpectedScreen() {
    Column(
        Modifier
            .graphicsLayer {
                rotationX = 70f
            }
            .background(Color.Blue.copy(0.1f))
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        repeat(3) {
            Box(
                Modifier
                    .clickable { }
                    .background(Color.Blue.copy(0.2f * (it + 1)))
                    .size(150.dp)
            )
        }
    }
}

@Preview
@Composable
private fun UnexpectedScreenPreview() {
    ExpectedScreen()
}
