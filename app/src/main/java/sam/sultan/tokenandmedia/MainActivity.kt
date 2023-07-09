package sam.sultan.tokenandmedia

import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import sam.sultan.tokenandmedia.databinding.ActivityMainBinding
import sam.sultan.tokenandmedia.ui.mainFragments.AddItemFragment
import sam.sultan.tokenandmedia.ui.mainFragments.MainPageFragment
import sam.sultan.tokenandmedia.ui.mainFragments.ProfilFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2)
        val navController =  fragment as NavHostFragment
        binding.bottomNavigationView.setupWithNavController(navController.navController)

        binding.floatingActionButton.setOnClickListener {
            navController.navController.navigate(R.id.addItemFragment)
        }

    }

}