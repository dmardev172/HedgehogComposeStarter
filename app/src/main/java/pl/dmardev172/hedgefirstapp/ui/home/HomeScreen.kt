package pl.dmardev172.hedgefirstapp.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(
    onItemClick: (Int) -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    val posts by viewModel.uiState.collectAsState()

    LazyColumn {
        items(posts) { post ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable { onItemClick(post.id) }) {
                Text(
                    text = post.title,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}
