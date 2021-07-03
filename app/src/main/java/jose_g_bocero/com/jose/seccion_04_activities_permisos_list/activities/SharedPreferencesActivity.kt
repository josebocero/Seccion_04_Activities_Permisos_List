package jose_g_bocero.com.jose.seccion_04_activities_permisos_list.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.R
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.app.preferences
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.databinding.ActivitySharedPreferencesBinding

class SharedPreferencesActivity : AppCompatActivity() {

    private lateinit var  binding: ActivitySharedPreferencesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySharedPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSve.setOnClickListener { setValuesSharedPreferences(); cleanEditTexts(); getValuesSharedPreferences(); }
        getValuesSharedPreferences()
    }

    private fun getValuesSharedPreferences() {
        if(preferences!!.name!!.isNotEmpty() && preferences!!.age >= 0) {
            binding.textViewSharedPreferences.text = "Welcome ${preferences!!.name}, your afe is ${preferences!!.age}"
        }else {
            binding.textViewSharedPreferences.text = "Welcome. Please save your name and your age"
        }
    }

    private fun setValuesSharedPreferences() {
        if(binding.editTextName.text.toString().isNotEmpty() && binding.editTextAge.text.toString().isNotEmpty()) {
            preferences!!.name = binding.editTextName.text.toString()
            preferences!!.age = binding.editTextAge.text.toString().toInt()
            Toast.makeText(this, "Values have been saved succesfully", Toast.LENGTH_LONG).show()
        }else {
            Toast.makeText(this, "Please fill the name and the age before saving", Toast.LENGTH_LONG).show()
        }
    }

    private fun cleanEditTexts() {
        binding.editTextName.text.clear()
        binding.editTextAge.setText("")
    }
}