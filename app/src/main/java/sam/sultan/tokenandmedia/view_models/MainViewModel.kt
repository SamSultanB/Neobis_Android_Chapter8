package sam.sultan.tokenandmedia.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sam.sultan.tokenandmedia.entities.ProductForm
import sam.sultan.tokenandmedia.entities.ProductResponse
import sam.sultan.tokenandmedia.repositories.MainRepository
import sam.sultan.tokenandmedia.utils.Resource

class MainViewModel: ViewModel() {

    val repository = MainRepository()

    val savingProduct: MutableLiveData<Resource<ProductForm>> = MutableLiveData()

    val products: MutableLiveData<Resource<List<ProductResponse>>> = MutableLiveData()

    fun saveProduct(productForm: ProductForm){
        viewModelScope.launch {
            savingProduct.postValue(Resource.Loading())
            val response = repository.saveProduct(productForm)
            if(response.isSuccessful){
                response.body()?.let {
                    savingProduct.postValue(Resource.Success(it))
                }
            }else{
                savingProduct.postValue(Resource.Error(response.message()))
            }
        }
    }

    fun getProducts(){
        viewModelScope.launch {
            products.postValue(Resource.Loading())
            val response = repository.getProducts()
            if(response.isSuccessful){
                response.body()?.let {
                    products.postValue(Resource.Success(it))
                }
            }else{
                products.postValue(Resource.Error(response.message()))
            }
        }
    }

}