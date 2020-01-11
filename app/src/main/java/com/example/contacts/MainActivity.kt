package com.example.contacts

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = DBHelper(this)
        val personList = db.getAll()

        val adapter = ArrayAdapter<Person>(this, R.layout.list_item, personList)
    }

    private class PersonAdapter
}
