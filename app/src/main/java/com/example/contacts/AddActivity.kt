package com.example.contacts

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*

class AddActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        btnSave.setOnClickListener {
            val name = name.text.toString()
            val phone = phone.text.toString()
            val email = email.text.toString()


            val db = DBHelper(this)

            val person = Person(0, name, phone, email)

            db.addContact(person)

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}