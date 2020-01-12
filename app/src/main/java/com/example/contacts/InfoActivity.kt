package com.example.contacts

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_info.*

class InfoActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val id = intent.getIntExtra("id", 0)

        val db = DBHelper(this)

        val person = db.findPersonById(id)

        name.setText(person.name)
        phone.setText(person.phone)
        email.setText(person.email)

        btnSave.setOnClickListener {

            val personToSave = Person()

            personToSave.name = name.text.toString()
            personToSave.phone = phone.text.toString()
            personToSave.email = email.text.toString()

            db.updatePersonById(id, personToSave)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnDelete.setOnClickListener {
            db.deletePersonById(id)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}