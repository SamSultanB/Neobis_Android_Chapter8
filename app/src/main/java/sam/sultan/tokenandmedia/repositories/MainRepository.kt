package sam.sultan.tokenandmedia.repositories

import sam.sultan.tokenandmedia.api.RetrofitInstance
import sam.sultan.tokenandmedia.api.SessionManager
import sam.sultan.tokenandmedia.entities.ProductForm

class MainRepository {

    private val mainApi = RetrofitInstance.apiMain

    suspend fun getProducts() = mainApi.getProduts("Bearer ${SessionManager.USER_TOKEN}")

    suspend fun saveProduct(productForm: ProductForm) = mainApi.saveProduct("Bearer ${SessionManager.USER_TOKEN}", productForm)

}