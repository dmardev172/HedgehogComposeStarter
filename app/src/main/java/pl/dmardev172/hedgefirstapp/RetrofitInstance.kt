package pl.dmardev172.hedgefirstapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// place in remote package
object RetrofitInstance {

    // use BASE_URL instead hardcoding
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: ApiService = retrofit.create(ApiService::class.java)
}