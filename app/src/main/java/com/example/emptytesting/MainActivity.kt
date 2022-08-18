package com.example.emptytesting

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.emptytesting.databinding.ActivityLoginBinding
import com.example.emptytesting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


//        val msg = intent.getStringExtra("user")
//        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

        binding.btnMain.setOnClickListener {
            val firstActivity = Intent(this, FirstActivity::class.java)
            startActivity(firstActivity)
        }

    }


}