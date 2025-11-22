package pl.dmardev172.hedgefirstapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel

@Composable
fun MyOtherScreen() {
    val myViewModel: MyViewModel = koinViewModel()
    val data by myViewModel.uiState.collectAsState()

    Column {
        Text(text = "More Data: ${data.value}")
        Button(onClick = { myViewModel.fetchMoreData() }) {
            Text("Fetch More Data")
        }
    }
}