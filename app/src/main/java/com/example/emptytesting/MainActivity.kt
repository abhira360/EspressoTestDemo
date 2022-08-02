package com.example.emptytesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.et_main)
        if(editText.length() ==0) {
            editText.error = "This field is required"
        }

        Log.d("root", editText.rootView.toString())
        val button = findViewById<Button>(R.id.btn_main)

        button.setOnClickListener {
            val firstActivity = Intent(this, FirstActivity::class.java)
            startActivity(firstActivity)
        }

    }


}