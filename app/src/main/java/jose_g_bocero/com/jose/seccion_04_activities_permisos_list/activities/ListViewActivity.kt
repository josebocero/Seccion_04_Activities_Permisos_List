package jose_g_bocero.com.jose.seccion_04_activities_permisos_list.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.R
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.adapters.PersonAdapter
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.databinding.ActivityListViewBinding
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.models.Person

class ListViewActivity : AppCompatActivity() {

    private lateinit var binding :ActivityListViewBinding

    private lateinit var adapter: PersonAdapter
    private lateinit var personList: List<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        personList = getPersons()
        adapter = PersonAdapter(this, R.layout.list_view_person, personList)
        binding.ListView.adapter = adapter
    }

    private fun getPersons() : List<Person> {
        return listOf(
            Person("Alejandro", "Lora", 27),
            Person("Fernando", "Vega", 37),
            Person("Alicia", "Gómez", 27),
            Person("Paula", "Escobar", 33),
            Person("Alberto", "Parada", 22),
            Person("Cristian", "Romero", 44),
            Person("Octavio", "Hernández", 23),
            Person("Yaiza", "Costi", 43),
            Person("Naomi", "Fernandez", 57),
            Person("Jason", "Otah", 16)
        )
    }
}