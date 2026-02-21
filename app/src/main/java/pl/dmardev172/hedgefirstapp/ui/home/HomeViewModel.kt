package pl.dmardev172.hedgefirstapp.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pl.dmardev172.hedgefirstapp.PostRepository
import pl.dmardev172.hedgefirstapp.RetrofitInstance
import pl.dmardev172.hedgefirstapp.model.Post

class HomeViewModel : ViewModel() {

    private val repository = PostRepository(RetrofitInstance.api)

    private val _uiState = MutableStateFlow<List<Post>>(emptyList())
    val uiState: StateFlow<List<Post>> = _uiState

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            try {
                _uiState.value = repository.getPosts()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}