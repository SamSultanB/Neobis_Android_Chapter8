package sam.sultan.tokenandmedia.ui.mainFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import sam.sultan.tokenandmedia.adapters.RecyclerViewAdapter
import sam.sultan.tokenandmedia.databinding.FragmentMyProductsBinding
import sam.sultan.tokenandmedia.entities.ProductForm
import sam.sultan.tokenandmedia.utils.Resource
import sam.sultan.tokenandmedia.view_models.MainViewModel

class MyProductsFragment : Fragment() {

    lateinit var binding: FragmentMyProductsBinding

    val viewModel = MainViewModel()

    val recyclerView = RecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMyProductsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getProducts()
        binding.backButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.recyclerViewFavorites.layoutManager = GridLayoutManager(this.context, 2)
        binding.recyclerViewFavorites.adapter = recyclerView

        viewModel.productsList.observe(viewLifecycleOwner, Observer{response ->
            if (response is Resource.Success){
                if (response.data?.isEmpty() == true){
                    binding.empty.visibility = View.VISIBLE
                }else{
                    response.data?.let { recyclerView.setProductList(it) }
                    binding.empty.visibility = View.GONE
                }
            }else if (response is Resource.Error){
                binding.empty.visibility = View.GONE
                Toast.makeText(requireContext(), "Problem", Toast.LENGTH_SHORT).show()
            }
        })

    }

}