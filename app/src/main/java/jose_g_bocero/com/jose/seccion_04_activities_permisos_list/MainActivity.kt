package jose_g_bocero.com.jose.seccion_04_activities_permisos_list

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        Toast.makeText(this,"Hello from the Toast",Toast.LENGTH_LONG).show()

        val layout = findViewById<ConstraintLayout>(R.id.constraint)

//        Snackbar.make(layout,"Hello from the SnackBar!",Snackbar.LENGTH_LONG).show()

        Snackbar.make(layout,"Hello from the SnackBar!",Snackbar.LENGTH_LONG).setAction("UNDO") {
            Snackbar.make(layout,"Email has been restored", Snackbar.LENGTH_LONG).show()
        }.show()
    }
}