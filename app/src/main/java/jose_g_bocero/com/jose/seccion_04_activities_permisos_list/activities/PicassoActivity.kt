package jose_g_bocero.com.jose.seccion_04_activities_permisos_list.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.R
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.databinding.ActivityPicassoBinding
import java.lang.Exception

class PicassoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPicassoBinding
    private val url1: String =
        "https://citysem.es/wp-content/uploads/2017/08/Dise%C3%B1o-de-identidad-corporativa.png"
    private val url2: String = "http://i.imgur.com/DvpvklR.png"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPicassoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLoader.setOnClickListener { loadImages() }

        Picasso.get().load(url1).fetch()
        /*Picasso.get()
            .load(url1)
            .fetch()*/
    }

    private fun loadImages() {
        Picasso.get().load(url1).resize(400, 400).centerCrop().into(binding.imageViewTop)

        //Picasso.get().load(url2).fit().into(binding.imageViewBottom)

        //Picasso.get().load(url2).fit().transform(CircleTransform()).into(binding.imageViewBottom)

        val context: Context = this

        Picasso.get().load(url2).fetch(object: Callback{
            override fun onSuccess() {
                binding.imageViewBottom.alpha = 0f
                Picasso.get().load(url2).fit().into(binding.imageViewBottom)
                binding.imageViewBottom.animate().setDuration(1300).alpha(1f).start()
            }

            override fun onError(e: Exception?) {

            }

        })
    }
}