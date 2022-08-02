package com.example.emptytesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    }
}