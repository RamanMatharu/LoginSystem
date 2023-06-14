package com.ramanmatharu.loginwindow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ResetPasswordActivity : AppCompatActivity() {
    lateinit var password: EditText
    lateinit var confirmPassword : EditText
    lateinit var resetPassBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        supportActionBar?.title = "Back"

        password = findViewById(R.id.password)
        confirmPassword = findViewById(R.id.confirmPassword)
        resetPassBtn = findViewById(R.id.resetPassBtn)

        resetPassBtn.setOnClickListener {
            if(password.text.toString().isNullOrEmpty()){
                password.error="Password must be filled up"
            }else if(password.text.length < 8){
                password.error = "Password must be of 8 characters"
            }else if(confirmPassword.text.toString().isNullOrEmpty()){
                confirmPassword.error = "Rewrite password for confirmation"
            }else if(!password.getText().toString().equals(confirmPassword.getText().toString())){
                Toast.makeText(this,"Passwords must match",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Password has changed successfully!",Toast.LENGTH_LONG).show()
                val  intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
    }
}