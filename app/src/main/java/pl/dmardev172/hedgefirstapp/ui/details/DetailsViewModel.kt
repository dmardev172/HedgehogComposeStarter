package pl.dmardev172.hedgefirstapp.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pl.dmardev172.hedgefirstapp.PostRepository
import pl.dmardev172.hedgefirstapp.RetrofitInstance
import pl.dmardev172.hedgefirstapp.model.Post

class DetailsViewModel(private val postId: Int) : ViewModel() {

    private val repository = PostRepository(RetrofitInstance.api)

    private val _post = MutableStateFlow<Post?>(null)
    val post: StateFlow<Post?> = _post

    init {
        fetchPost()
    }

    private fun fetchPost() {
        viewModelScope.launch {
            try {
                _post.value = repository.getPost(postId)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}