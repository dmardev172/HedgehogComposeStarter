package pl.dmardev172.hedgefirstapp

import pl.dmardev172.hedgefirstapp.model.Post

class PostRepository(private val api: ApiService) {

    suspend fun getPosts(): List<Post> {
        return api.getPosts()
    }

    suspend fun getPost(id: Int): Post {
        return api.getPost(id)
    }
}