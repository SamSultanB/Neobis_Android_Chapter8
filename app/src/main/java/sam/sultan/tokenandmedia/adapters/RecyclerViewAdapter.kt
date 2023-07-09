package sam.sultan.tokenandmedia.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import sam.sultan.tokenandmedia.R
import sam.sultan.tokenandmedia.databinding.ItemBinding
import sam.sultan.tokenandmedia.entities.ProductResponse

class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.ProductHolder>() {

     private var productList: List<ProductResponse> = emptyList()

    class ProductHolder(product: View): RecyclerView.ViewHolder(product){
        val binding = ItemBinding.bind(product)

        fun bind(product: ProductResponse, position: Int, size: Int) = with(binding){
            name.text = product.name
            shortDescription.text = product.short_description
            price.text = product.price.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val productView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ProductHolder(productView)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bind(productList[position], position, productList.size)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun setProductList(productListNew: List<ProductResponse>){
        productList = productListNew
    }

}