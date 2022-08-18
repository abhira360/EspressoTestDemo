package com.example.emptytesting

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.emptytesting.databinding.ActivityLoginBinding
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.absoluteValue
import kotlin.random.Random


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val validUser = "Abhishek"
    private val validPassword = "123456"
    private lateinit var newTimer : CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etUserPassword.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                binding.btnSubmit.isEnabled = s.toString().trim().length==6
            }

            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

                // TODO Auto-generated method stub
            }

            override fun afterTextChanged(s: Editable) {

                // TODO Auto-generated method stub
            }
        })

        val df = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.US).format(Date())
        binding.tvDateTime.text = df

//         val sdf = SimpleDateFormat("MMM").format(Date())
//        binding.tvDate.text = sdf.format(Date())

        newTimer = object : CountDownTimer(1000000000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val c = Calendar.getInstance()
//                val ba = c.get(Calendar.MONTH+1)
//                binding.tvDate.text = "$ba"
//                binding.tvDate.text = "${c.get(Calendar.HOUR)} :  ${c.get(Calendar.MINUTE)}  : ${c.get(Calendar.SECOND)} "
                binding.tvDate.text = "${c.time}"
            }

            override fun onFinish() {}
        }
        newTimer.start()


        binding.btnSubmit.setOnClickListener { submitCredentials() }

    }

    override fun onDestroy() {
        super.onDestroy()
        newTimer.cancel()

    }

    private fun submitCredentials() {

        var name = binding.etUserName.text.toString()
        val password = binding.etUserPassword.text.toString()

        if(name == validUser && password == validPassword ) {

            val mainActivity = Intent(this, MainActivity::class.java)
            mainActivity.putExtra("user", "$name Logged in!")
            startActivity(mainActivity)

        }
        else {
            toast("Please enter valid user name and password!")
        }
    }

    private fun toast(msg:String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

}