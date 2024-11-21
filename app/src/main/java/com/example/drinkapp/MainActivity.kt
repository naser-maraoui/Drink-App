package com.example.drinkapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextWatcher
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    var TAG = "test"
    private val jusorange = "Jus Orange"
    private val jusfrese = "Jus Frese"
    private val jusmilk = "Jus Milk"
    private val juschoclat = "Jus Choclat"

    lateinit var chosemenu : AutoCompleteTextView
    lateinit var priseEt : TextView
    lateinit var orderBtn : Button

    val prix = mapOf(
        jusorange to 7000 ,
        juschoclat to 8000 ,
        jusmilk to 5000 ,
        jusfrese to 6000
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initialize()
        dropmenu()

        chosemenu.setOnItemClickListener { adapterView, view, i, l ->
            val result = prix[chosemenu.text.toString()]
            priseEt.setText(result.toString())
        }

        orderBtn.setOnClickListener{
            val message = Intent(Intent.ACTION_SEND)
            message.type = "text/plain"
            message.putExtra(Intent.EXTRA_TEXT, "I want to order : ${chosemenu.text.toString()}")
            startActivity(message)
        }





    }

    private fun dropmenu(){
        val listeoforder = listOf(jusorange , jusfrese , juschoclat , jusmilk)
        val adapter = ArrayAdapter(this , R.layout.dropdownmenu , listeoforder)
        chosemenu.setAdapter(adapter)
    }

    private fun initialize(){
        chosemenu = findViewById(R.id.chose_menu)
        priseEt= findViewById(R.id.prix)
        orderBtn = findViewById(R.id.button_order)
    }
}