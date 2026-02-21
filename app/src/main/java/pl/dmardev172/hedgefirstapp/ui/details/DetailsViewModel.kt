package pl.dmardev172.hedgefirstapp.ui.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pl.dmardev172.hedgefirstapp.PostRepository
import pl.dmardev172.hedgefirstapp.RetrofitInstance
import pl.dmardev172.hedgefirstapp.UiState
import pl.dmardev172.hedgefirstapp.model.Post
import retrofit2.HttpException
import java.io.IOException

class DetailsViewModel(private val postId: Int) : ViewModel() {

    private val repository = PostRepository(RetrofitInstance.api)

    private val _uiState = MutableStateFlow<UiState<Post>>(UiState.Loading)
    val uiState: StateFlow<UiState<Post>> = _uiState

    init {
        fetchPost()
    }

    private fun fetchPost() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            try {
                val post = repository.getPost(postId)
                _uiState.value = UiState.Success(post)
            } catch (e: IOException) {
                _uiState.value = UiState.Error("No Internet Connection")
            } catch (e: HttpException) {
                _uiState.value = UiState.Error("Server Error: ${e.code()}")
            } catch (e: Exception) {
                _uiState.value = UiState.Error("Unknown Error")
            }
        }
    }
}