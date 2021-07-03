package jose_g_bocero.com.jose.seccion_04_activities_permisos_list.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.R
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.databinding.ActivityListViewBinding
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.databinding.ListViewPersonBinding
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.models.Person
import jose_g_bocero.com.jose.seccion_04_activities_permisos_list.others.inflate

class PersonAdapter(val context: Context,val layout: Int, val list: List<Person>) : BaseAdapter() {

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val view: View
        val vh: PersonViewHolder

        if(convertView == null) {
            view = parent!!.inflate(layout)
            vh = PersonViewHolder(view)
            view.tag = vh
        }else{
            view = convertView
            vh = view.tag as PersonViewHolder
        }

        val fullName ="${list[position].firstName}, ${list[position].lastName}"
        vh.fullName.text = fullName
        vh.age.text = "${list[position].age}"

        return view
    }
}

private class PersonViewHolder(view: View) {

    val binding = ListViewPersonBinding.bind(view)

    val fullName: TextView = binding.textViewName
    val age: TextView = binding.textViewAge
}
