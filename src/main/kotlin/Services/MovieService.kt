package Services


import WebClient.API_KEY
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {
    @GET(API_KEY)
    fun findTop250Movies(): Call<ResponseBody>
}