package sam.sultan.tokenandmedia.ui.authFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sam.sultan.tokenandmedia.databinding.FragmentCreatePasswordBinding
import sam.sultan.tokenandmedia.view_models.AuthViewModel

class CreatePasswordFragment : Fragment() {

    lateinit var binding: FragmentCreatePasswordBinding
    val viewModel = AuthViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCreatePasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.nextButton.setOnClickListener {
            val password1 = binding.password1.text.toString()
            val password2 = binding.password2.text.toString()
            if(viewModel.samePassword(password1, password2) !=  null){
                binding.passwordContainer2.helperText = viewModel.samePassword(password1, password2)
            }
        }
        binding.backButton.setOnClickListener { findNavController().navigateUp() }
    }

}