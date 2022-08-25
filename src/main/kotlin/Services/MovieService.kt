package Services


import WebClient.API_KEY
import models.Top250Data
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {
    @GET(API_KEY)
    fun findTop250Movies(): Call<Top250Data>
}