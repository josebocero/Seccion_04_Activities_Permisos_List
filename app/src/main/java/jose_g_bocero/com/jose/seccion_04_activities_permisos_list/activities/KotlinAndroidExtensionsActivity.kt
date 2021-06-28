package jose_g_bocero.com.jose.seccion_04_activities_permisos_list.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.R
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.databinding.ActivityKotlinAndroidExtensionsBinding

// Deprecated kotlin Android Extensions. Migrado a ViewBindings
//import kotlinx.android.synthetic.main.activity_kotlin_android_extensions.*

class KotlinAndroidExtensionsActivity : AppCompatActivity() {

    // Variable para las vistas con ViewBindings
    private lateinit var binding: ActivityKotlinAndroidExtensionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Al usar ViewBindings hay que modificar el layout por el de la línea 27 'setContentView(binding.root)'
        //setContentView(R.layout.activity_kotlin_android_extensions)

        // Inflar la vista con binding
        binding = ActivityKotlinAndroidExtensionsBinding.inflate(layoutInflater)
        // setContentView modificado para usar ViewBindings
        setContentView(binding.root)

        // Forma clásica de llamar a la vista

        val btn = findViewById<Button>(R.id.buttonById)
        btn.setOnClickListener { Toast.makeText(this,"Click By ID!", Toast.LENGTH_LONG).show() }

        // Llamando a la vista a través de ViewBindings
        binding.buttonByKAT.setOnClickListener {  }
    }
}