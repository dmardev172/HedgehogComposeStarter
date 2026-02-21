package pl.dmardev172.hedgefirstapp

import pl.dmardev172.hedgefirstapp.model.Post
import retrofit2.http.GET
import retrofit2.http.Path

// place in remote package
interface ApiService {

    @GET("posts")
    suspend fun getPosts():List<Post>

    @GET("posts/{id}")
    suspend fun getPost(@Path("id") id: Int): Post
}