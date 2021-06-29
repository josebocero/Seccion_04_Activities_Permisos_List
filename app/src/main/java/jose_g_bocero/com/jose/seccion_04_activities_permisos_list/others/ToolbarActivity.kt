package jose_g_bocero.com.jose.seccion_04_activities_permisos_list.others

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.models.IToolbar

open class ToolbarActivity : AppCompatActivity(), IToolbar {

    protected var _toolbar: Toolbar? = null

    override fun toolbarToLoad(toolbar: Toolbar?) {
        _toolbar = toolbar
        _toolbar?.let { setSupportActionBar(_toolbar) }
    }

    override fun enableHomeDisplay(value: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(value)
    }
}