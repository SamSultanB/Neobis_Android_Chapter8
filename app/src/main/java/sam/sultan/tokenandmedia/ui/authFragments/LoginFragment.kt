package sam.sultan.tokenandmedia.ui.authFragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import sam.sultan.tokenandmedia.MainActivity
import sam.sultan.tokenandmedia.R
import sam.sultan.tokenandmedia.databinding.FragmentLoginBinding
import sam.sultan.tokenandmedia.entities.LoginForm
import sam.sultan.tokenandmedia.utils.Resource
import sam.sultan.tokenandmedia.view_models.AuthViewModel

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding
    val viewModel = AuthViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
            val name = binding.nameField.text.toString()
            val password = binding.passwordField.text.toString()
            if(viewModel.loginField(name, password) == null){
                val loginForm = LoginForm(name, password)
                viewModel.login(loginForm)
            }else{
                Toast.makeText(requireContext(), viewModel.loginField(name, password), Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.login.observe(viewLifecycleOwner, Observer{response ->
            if (response is Resource.Success){
                var intent = Intent(this.activity, MainActivity::class.java)
                startActivity(intent)
                activity?.finish()
            }else if(response is Resource.Error){
                Toast.makeText(requireContext(), response.message, Toast.LENGTH_SHORT).show()
            }
        })

        binding.register.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }
    }

}