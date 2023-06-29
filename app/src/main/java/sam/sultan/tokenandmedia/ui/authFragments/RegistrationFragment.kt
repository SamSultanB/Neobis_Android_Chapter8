package sam.sultan.tokenandmedia.ui.authFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sam.sultan.tokenandmedia.R
import sam.sultan.tokenandmedia.databinding.FragmentRegistrationBinding
import sam.sultan.tokenandmedia.entities.RegistrationForm
import sam.sultan.tokenandmedia.view_models.AuthViewModel

class RegistrationFragment : Fragment() {

    lateinit var binding: FragmentRegistrationBinding
    val viewModel = AuthViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.buttonNext.setOnClickListener {
            val email = binding.emailField.text.toString()
            val name = binding.nameField.text.toString()
            if(viewModel.validEmail(email) != null){
                binding.emailContainer.helperText = viewModel.validEmail(email)
            }else if(name.isEmpty()){
                binding.name.helperText = "Введите имя пользователя"
            }else{
                val bundle = Bundle()
                bundle.putString("name", name)
                bundle.putString("email", email)
                findNavController().navigate(R.id.action_registrationFragment_to_createPasswordFragment, bundle)
            }
        }
        binding.backButton.setOnClickListener { findNavController().navigateUp() }
    }

}