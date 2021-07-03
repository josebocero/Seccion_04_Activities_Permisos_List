package jose_g_bocero.com.jose.seccion_04_activities_permisos_list.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.MainActivity
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.R
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.databinding.ActivityExtensionFunctionsBinding
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.others.goToActivity
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.others.loadByURL
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.others.snackBar
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.others.toast

class ExtensionFunctionsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExtensionFunctionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExtensionFunctionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonToast.setOnClickListener { toast(R.string.extensions_go_to) }
        binding.buttonSnackBacr.setOnClickListener {
            snackBar(
                "I love extension functions!",
                action = "Undo"
            ) { toast("Undo !!") }
        }
        binding.buttonLoadByUrl.setOnClickListener { binding.imageViewLoadedByUrl.loadByURL("https://citysem.es/wp-content/uploads/2017/08/Dise%C3%B1o-de-identidad-corporativa.png") }
        binding.buttonGoToActivity.setOnClickListener {goToActivity<MainActivity> { putExtra("id", 1)} }

    }
}