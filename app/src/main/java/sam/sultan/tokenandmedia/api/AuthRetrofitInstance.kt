package sam.sultan.tokenandmedia.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sam.sultan.tokenandmedia.utils.Constants

class AuthRetrofitInstance {

    companion object{
        private val retrofit by lazy {
            Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }

        val api by lazy{
            retrofit.create(AuthApi::class.java)
        }

    }

}