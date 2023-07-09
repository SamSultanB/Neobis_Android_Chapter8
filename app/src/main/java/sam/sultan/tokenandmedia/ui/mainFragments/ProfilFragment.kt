package sam.sultan.tokenandmedia.ui.mainFragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import sam.sultan.tokenandmedia.R
import sam.sultan.tokenandmedia.api.SessionManager
import sam.sultan.tokenandmedia.databinding.FragmentProfilBinding
import sam.sultan.tokenandmedia.databinding.LogoutDialogScreenBinding
import sam.sultan.tokenandmedia.utils.Resource
import sam.sultan.tokenandmedia.view_models.AuthViewModel

class ProfilFragment : Fragment() {

    lateinit var binding: FragmentProfilBinding

    val viewModel = AuthViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentProfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getProfile()
        binding.buttonChange.setOnClickListener {
            findNavController().navigate(R.id.action_profilFragment_to_editProfileFragment)
        }
        binding.logout.setOnClickListener {
            logout()
        }
        binding.myItems.setOnClickListener{
            findNavController().navigate(R.id.action_profilFragment_to_myProductsFragment)
        }

        viewModel.profile.observe(viewLifecycleOwner, Observer{ response ->
            if (response is Resource.Success){
                binding.profileName.text = response.data?.username
                binding.progressBar.visibility = View.GONE
                binding.container.visibility = View.VISIBLE
            }else if (response is Resource.Loading){
                binding.progressBar.visibility = View.VISIBLE
                binding.container.visibility = View.GONE
            }else if (response is Resource.Error){
                Toast.makeText(requireContext(), response.message, Toast.LENGTH_SHORT).show()
                binding.progressBar.visibility = View.GONE
                binding.container.visibility = View.VISIBLE
            }
        })

    }

    private fun logout(){
        val dialog = AlertDialog.Builder(requireContext(), R.style.CustomAlertDialog).create()
        val logout = LogoutDialogScreenBinding.inflate(layoutInflater)
        dialog.setView(logout.root)
        logout.logoutButton.setOnClickListener {
            dialog.dismiss()
            activity?.finish()
        }
        logout.cancelButton.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()

    }

}