package com.example.contacts

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import java.io.Serializable

data class Person(var name: String = "", var phone: String = "", var email: String = "")

class PersonAdapter(private val context: Context, private val dataSource: ArrayList<Person>): BaseAdapter() {

    override fun getItem(position: Int): Person {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return dataSource.size
    }

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.list_item, parent, false)

        val personNameView = rowView.findViewById(R.id.name) as TextView

        personNameView.text = getItem(position).name
        return rowView
    }
}