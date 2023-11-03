package farm.favbet.game.fovorit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import farm.favbet.game.fovorit.databinding.ActivityFarmUsAbBinding

class FarmUsAb : AppCompatActivity() {
    private lateinit var binding:ActivityFarmUsAbBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFarmUsAbBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btBack.setOnClickListener{finish()}
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}