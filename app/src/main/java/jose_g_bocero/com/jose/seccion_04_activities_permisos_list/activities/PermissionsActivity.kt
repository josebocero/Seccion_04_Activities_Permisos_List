package jose_g_bocero.com.jose.seccion_04_activities_permisos_list.activities

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.R
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.databinding.ActivityPermissionsBinding

class PermissionsActivity : AppCompatActivity() {

    private val requestCameraPermission = 100
    private val requestCameraPicture = 200
    private lateinit var binding: ActivityPermissionsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPermissionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonPicture.setOnClickListener { getPictureFromCameraAskingPermissions() }
    }

    private fun getPictureFromCameraAskingPermissions() {
        // Añadir permiso al manifest
        // Comprobar el permiso de la camara
        if(ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // Si no ha sido aceptado previamente (Para versiones desde la 6.0 [API 23] en adelante)
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), requestCameraPermission)
        }else{
            // Si ha sido aceptado previamente (Para versiones inferiores a la 6.0 [API 23])
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, requestCameraPicture)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode) {
            requestCameraPermission -> {
                if(grantResults.size == 1 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // Permiso aceptado
                    val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(intent, requestCameraPicture)
                }else {
                    // Permiso denegado
                    Toast.makeText(this,"You can't take a picture if you don't allow it", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when(requestCode) {
            requestCameraPicture -> {
                // Comprobar si el resultado es bueno
                if(resultCode == Activity.RESULT_OK) {
                    // Obtenemos los extras del intent recibido por parametros
                    val extras = data!!.extras
                    // Formamos el bitmap a partir de los extras
                    val imageBitmap = extras?.get("data") as Bitmap
                    // Cargamos la foto como bitmap en el imageView
                    binding.imageViewPicture.setImageBitmap(imageBitmap)
                }else {
                    // La foto no ha sido tomada con éxito
                    Toast.makeText(this,"Picture has failed", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}