package sam.sultan.tokenandmedia.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import sam.sultan.tokenandmedia.entities.ProfileForm

interface MainApi {

    @GET("product/")
    suspend fun getProduts(): Response<List<ProfileForm>>

    @POST("product/")
    suspend fun saveProduct()

    @GET("product/{id}/")
    suspend fun getProduct()

}