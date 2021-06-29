package jose_g_bocero.com.jose.seccion_04_activities_permisos_list.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.R
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.databinding.ActivityIntentsBinding
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.models.Student

class IntentsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntentsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonIntentExtras.setOnClickListener { goIntentExtras() }
        binding.buttonIntentFlags.setOnClickListener { goIntentFlags() }
        binding.buttonIntentObject.setOnClickListener { goIntentObject() }
    }

    private fun goIntentExtras() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
        intent.putExtra("name", "Alejandro")
        intent.putExtra("lastName", "Lora")
        intent.putExtra("age", 27)
        intent.putExtra("developer", true)
        startActivity(intent)
    }

    private fun goIntentFlags() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
        //intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY // No guarda el activity en el stack
        //intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION // No animación
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // Borra el stack completo
        startActivity(intent)
        //finish() // Destruye estee activity evitando que entre en el stack
    }
    private fun goIntentObject() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
        val student = Student("Alberto", "Santos", 24, false)
        intent.putExtra("student", student)
        startActivity(intent)
    }


}