package pl.dmardev172.hedgefirstapp

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.getViewModel

@Composable
fun MyScreen() {
    val myViewModel: MyViewModel = getViewModel()  // getViewModel() is deprecated
    val data by myViewModel.uiState.collectAsState()

    Column {
        Text(text = "Data: ${data.value}")
        Button(onClick = { myViewModel.fetchData() }) {
            Text("Fetch Data")
        }
    }
}