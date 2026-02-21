package pl.dmardev172.hedgefirstapp.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.dmardev172.hedgefirstapp.Item

/*
@Composable
fun HomeScreen(onNavigateToDetails: (Int) -> Unit) {
//    Button(onClick = onClick) { Text("Go to details") } //yaycarnia haha
    Surface(modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)) {
        Row(modifier = Modifier.padding(24.dp)) {
            OutlinedButton(
                onClick = { onNavigateToDetails(5) },
                border = BorderStroke(2.dp, Color.Blue),
                modifier = Modifier.padding(8.dp)
            ) { Text("Go to details") }
        }
    }
}*/

@Composable
fun HomeScreen(
    onItemClick: (Int) -> Unit
) {
    val items = List(20) { index ->
        Item(id = index + 1, title = "Element ${index + 1}")
    }

    LazyColumn {
        items(items) { item ->
            ListItemRow(
                item = item,
                onClick = { onItemClick(item.id) }
            )
        }
    }
}

@Composable
fun ListItemRow(
    item: Item,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() }
    ) {
        Text(
            text = item.title,
            modifier = Modifier.padding(16.dp))
    }
}