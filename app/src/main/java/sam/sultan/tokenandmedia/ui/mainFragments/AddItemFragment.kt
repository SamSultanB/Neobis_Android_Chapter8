package sam.sultan.tokenandmedia.ui.mainFragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sam.sultan.tokenandmedia.R
import sam.sultan.tokenandmedia.databinding.FragmentAddItemBinding


class AddItemFragment : Fragment() {

    lateinit var binding: FragmentAddItemBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddItemBinding.inflate(inflater, container, false)
        return binding.root
    }

}