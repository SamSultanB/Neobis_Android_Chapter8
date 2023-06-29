package sam.sultan.tokenandmedia.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sam.sultan.tokenandmedia.utils.Constants
import sam.sultan.tokenandmedia.utils.TokenInterceptor

class MainRetrofitInstance {

    companion object{
        val token = ""
        val tokenInterceptor = TokenInterceptor(token)
        val client = OkHttpClient.Builder()
            .addInterceptor(tokenInterceptor)
            .build()

        private val retrofit by lazy {
            Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        val apiAuth by lazy {
            retrofit.create(AuthApi::class.java)
        }

        val apiMain by lazy {
            retrofit.create(MainApi::class.java)
        }
    }

}