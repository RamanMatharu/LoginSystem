package com.ramanmatharu.loginwindow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class ForgotPswdActivity : AppCompatActivity() {
    lateinit var mail : EditText
    lateinit var generateOtp : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_pswd)

        supportActionBar?.title = "Back"

        mail = findViewById(R.id.mail)
        generateOtp = findViewById(R.id.generateOtp)

        generateOtp.setOnClickListener {
            if(mail.text.toString().isNullOrEmpty()){
                mail.error="It is mandatory to fill email"
            }else{
                var intent = Intent(this,GenerateOtpActivity::class.java)
                val mail = mail.text.toString()
                intent.putExtra("mail",mail)
                startActivity(intent)
            }
        }
    }
}