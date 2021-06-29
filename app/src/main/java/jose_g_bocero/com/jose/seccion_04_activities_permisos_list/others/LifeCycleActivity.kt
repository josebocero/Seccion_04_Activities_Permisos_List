package jose_g_bocero.com.jose.seccion_04_activities_permisos_list.others

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.R
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.activities.LifeCycleEventsActivity

class LifeCycleActivity : LifeCycleEventsActivity() {

    private var exitEnabled = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
    }

    override fun onBackPressed() {
        if (exitEnabled) {
            super.onBackPressed()
        }
        exitEnabled = true
        Toast.makeText(this, "Click back again to exit this sreen", Toast.LENGTH_LONG).show()
        Handler(Looper.getMainLooper()).postDelayed(Runnable { exitEnabled = false }, 2000)
    }

}