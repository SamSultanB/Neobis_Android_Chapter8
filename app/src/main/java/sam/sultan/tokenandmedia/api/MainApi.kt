package sam.sultan.tokenandmedia.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import sam.sultan.tokenandmedia.entities.ProductForm
import sam.sultan.tokenandmedia.entities.ProductResponse
import sam.sultan.tokenandmedia.entities.ProfileForm

interface MainApi {

    @GET("product/")
    suspend fun getProduts(@Header("Authorization") token: String): Response<List<ProductResponse>>

    @POST("product/")
    suspend fun saveProduct(@Header("Authorization") token: String, @Body productForm: ProductForm): Response<ProductForm>

    @GET("product/{id}/")
    suspend fun getProduct(@Header("Authorization") token: String, @Path("id") id: Int)

}