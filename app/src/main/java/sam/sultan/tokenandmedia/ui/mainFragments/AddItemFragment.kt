package sam.sultan.tokenandmedia.ui.mainFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import sam.sultan.tokenandmedia.api.SessionManager
import sam.sultan.tokenandmedia.databinding.FragmentAddItemBinding
import sam.sultan.tokenandmedia.entities.ProductForm
import sam.sultan.tokenandmedia.utils.Resource
import sam.sultan.tokenandmedia.view_models.MainViewModel


class AddItemFragment : Fragment() {

    lateinit var binding: FragmentAddItemBinding

    val viewModel = MainViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.buttonChange.setOnClickListener {
            val name = binding.name.text.toString()
            val description = binding.description.text.toString()
            val price = binding.price.text.toString().toInt()
            if(!name.isEmpty() && !description.isEmpty()){
                val productForm = ProductForm(name, price, description)
                viewModel.saveProduct(productForm)
            }
        }

        viewModel.savingProduct.observe(viewLifecycleOwner, Observer{response ->
            if (response is Resource.Success){
                findNavController().navigateUp()
            }else if (response is Resource.Error){
                Toast.makeText(requireContext(), response.message, Toast.LENGTH_SHORT).show()
            }
        })
    }

}