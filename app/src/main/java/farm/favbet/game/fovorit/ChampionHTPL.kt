package farm.favbet.game.fovorit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import farm.favbet.game.fovorit.databinding.ActivityChampionHtplBinding

class ChampionHTPL : AppCompatActivity() {
    private lateinit var binding:ActivityChampionHtplBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChampionHtplBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonFinishHtpl.setOnClickListener{
            finish()
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}