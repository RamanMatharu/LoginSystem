package com.ramanmatharu.loginwindow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    lateinit var forgotPswd : TextView
    lateinit var email : EditText
    lateinit var pswd : EditText
    lateinit var loginBtn : Button
    lateinit var register : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        Toast.makeText(this,"on create",Toast.LENGTH_LONG).show()

        forgotPswd = findViewById(R.id.forgotPswd)
        email = findViewById(R.id.email)
        pswd = findViewById(R.id.password)
        loginBtn = findViewById(R.id.loginBtn)
        register = findViewById(R.id.register)

        //moving to new window for resetting password
        forgotPswd.setOnClickListener {
            var intent = Intent(this,ForgotPswdActivity::class.java)
            startActivity(intent)
        }

        //validations
        loginBtn.setOnClickListener {
            if(email.text.toString().isNullOrEmpty()){
                email.error="It is mandatory to fill username"
            }else if(pswd.text.toString().isNullOrEmpty()){
                pswd.error="It is mandatory to fill password"
            }else{
                Toast.makeText(this,"Login Successful",Toast.LENGTH_LONG).show()
            }
        }

        register.setOnClickListener {
            var intent = Intent(this,RegisterActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Toast.makeText(this,"on start",Toast.LENGTH_LONG).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this,"on resume",Toast.LENGTH_LONG).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this,"on pause",Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this,"on stop",Toast.LENGTH_LONG).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this,"on restart",Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this,"on start",Toast.LENGTH_LONG).show()
    }
}

