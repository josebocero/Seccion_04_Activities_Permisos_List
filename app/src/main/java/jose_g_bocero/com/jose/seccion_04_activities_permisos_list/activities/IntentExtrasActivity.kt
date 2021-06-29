package jose_g_bocero.com.jose.seccion_04_activities_permisos_list.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.R
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.databinding.ActivityIntentExtrasBinding
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.models.Student

class IntentExtrasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityIntentExtrasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityIntentExtrasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonBack.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    IntentsActivity::class.java
                )
            )
        }

        val isExtraSet = setIntentExtrasFromPreviousActivity()
        val isParcelableSet = setParcelableExtraFromPreviousActivity()

        if(!isExtraSet && !isParcelableSet) {
            binding.checkBoxDeveloper.visibility = View.INVISIBLE
        }

    }

    private fun setParcelableExtraFromPreviousActivity(): Boolean{
        val student = intent.getParcelableExtra<Student>("student")
        student?.let {
            binding.textViewName.text = student.name
            binding.textViewLastName.text = student.lastName
            binding.textViewAge.text = "${student.age}"
            binding.checkBoxDeveloper.text = "Developer"
            binding.checkBoxDeveloper.isChecked = student.isDeveloper
            return true
        }
        return false
    }

    private fun setIntentExtrasFromPreviousActivity(): Boolean {
        val name: String? = intent.getStringExtra("name")
        val lastName: String? = intent.getStringExtra("lastName")
        val age: Int = intent.getIntExtra("age", -1)
        val developer = intent.getBooleanExtra("developer", false)

        if (name != null && lastName != null && age >= 0) {
            binding.textViewName.text = name
            binding.textViewLastName.text = lastName
            binding.textViewAge.text = "$age"
            binding.checkBoxDeveloper.text = "Developer"
            binding.checkBoxDeveloper.isChecked = developer
            return true
        }
        return false
    }
}