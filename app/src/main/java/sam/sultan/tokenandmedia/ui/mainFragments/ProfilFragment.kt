package sam.sultan.tokenandmedia.ui.mainFragments

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import sam.sultan.tokenandmedia.R
import sam.sultan.tokenandmedia.databinding.FragmentProfilBinding
import sam.sultan.tokenandmedia.databinding.LogoutDialogScreenBinding

class ProfilFragment : Fragment() {

    lateinit var binding: FragmentProfilBinding

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
        binding.buttonChange.setOnClickListener {
            findNavController().navigate(R.id.action_profilFragment_to_editProfileFragment)
        }
        binding.favorites.setOnClickListener {
            findNavController().navigate(R.id.action_profilFragment_to_favoritesFragment)
        }
        binding.logout.setOnClickListener {
            logout()
        }
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