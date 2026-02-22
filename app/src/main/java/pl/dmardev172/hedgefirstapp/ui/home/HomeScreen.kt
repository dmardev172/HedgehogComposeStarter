package pl.dmardev172.hedgefirstapp.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import pl.dmardev172.hedgefirstapp.UiState
import pl.dmardev172.hedgefirstapp.model.Post
import pl.dmardev172.hedgefirstapp.viewmodels.PostSharedViewModel

@Composable
fun HomeScreen(
    viewModel: PostSharedViewModel,
    onNavigateToDetails: () -> Unit
) {
    val state by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    // Side Effect - show Snackbar if error only
    LaunchedEffect(state) {
        if (state is UiState.Error) {
            snackbarHostState.showSnackbar(
                message = (state as UiState.Error).message,
                actionLabel = "Try Again"
            ).let { result ->
                if (result == SnackbarResult.ActionPerformed) {
                    viewModel.retry()
                }
            }
        }
    }

    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { padding ->

        Box(modifier = Modifier.fillMaxSize().padding(padding)) {

            when (state) {

                UiState.Loading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                is UiState.Error -> {
                    // May be empty because Snackbar shows the error
                }

                is UiState.Success -> {
                    val posts = (state as UiState.Success<List<Post>>).data

                    LazyColumn {
                        items(posts) { post ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp)
                                    .clickable {
                                        // onItemClick(post.id)
                                        viewModel.selectPost(post)
                                        onNavigateToDetails()
                                    }
                            ) {
                                Text(
                                    text = post.title,
                                    modifier = Modifier.padding(16.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}