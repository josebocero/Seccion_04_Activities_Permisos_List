package jose_g_bocero.com.jose.seccion_04_activities_permisos_list.others

import android.content.Context

class MySharedPreferences(context: Context) {

    // Nombgre fichero shared preferences
    private val fileName = "mis_preferenceias"

    // Instancia de ese fichero
    private val prefs = context.getSharedPreferences(fileName, Context.MODE_PRIVATE)

    // Por cada una de las variables que vamos a guardar en nuestro fichero shares preferences
    var name: String?
        get() = prefs.getString("name", "")
        set(value) = prefs.edit().putString("name", value).apply()

    var age: Int
        get() = prefs.getInt("age", -1)
        set(value) = prefs.edit().putInt("age", value).apply()
}