package th.brandenburg.quickwatch

import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import th.brandenburg.quickwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    public lateinit var backButton: ImageButton
    private lateinit var toolbarTitle: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        backButton = findViewById(R.id.backButton)
        toolbarTitle = findViewById(R.id.toolbarTitle)

        //Zurück-Button klickbar machen
        backButton.setOnClickListener {
            supportFragmentManager.popBackStack()
        }

        backButton = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            supportFragmentManager.popBackStack()
        }

        toolbarTitle.text = "Quickwatch"


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
                }
            }
            true
        }
    }

    private fun replaceFragment(fragement : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragement)
        fragmentTransaction.commit()
    }

}