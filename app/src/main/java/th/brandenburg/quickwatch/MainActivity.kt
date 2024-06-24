package th.brandenburg.quickwatch

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import th.brandenburg.quickwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.frame_layout, Filme())
                .commit()
        }

        var toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.filme -> replaceFragment(Filme())
                R.id.serien -> replaceFragment(Serien())
                else -> {
                    // Handle the else case if needed
                }
            }
            true // Return true to indicate the selection is handled
        }
    }

    private fun replaceFragment(fragement : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragement)
        fragmentTransaction.commit()
    }
}