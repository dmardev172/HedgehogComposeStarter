package pl.dmardev172.hedgefirstapp.screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DetailsScreen(onBack: () -> Unit) {
    Surface(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
        Row(modifier = Modifier.padding(24.dp)) {
            OutlinedButton(
                onClick = onBack,
                border = BorderStroke(1.dp, Color.Red),
                modifier = Modifier.padding(8.dp)
            ) { Text("Back") }
        }
    }
}