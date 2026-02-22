package pl.dmardev172.hedgefirstapp.ui.details

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import pl.dmardev172.hedgefirstapp.viewmodels.PostSharedViewModel

@Composable
fun DetailsScreen(
    viewModel: PostSharedViewModel,
    onBack: () -> Unit
) {
    val post by viewModel.selectedPost.collectAsState()

    if (post == null) {
        Text("Out of data")
        return
    }

    Surface(modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = post!!.title, style = MaterialTheme.typography.headlineMedium)

            Spacer(modifier = Modifier.height(24.dp))

            Text(text = post!!.body)

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedButton(
                onClick = onBack,
                border = BorderStroke(2.dp, Color.Red),
                modifier = Modifier.padding(8.dp)
            ) { Text("Back") }
        }
    }
}