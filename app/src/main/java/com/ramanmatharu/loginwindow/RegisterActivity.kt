package com.ramanmatharu.loginwindow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import javax.microedition.khronos.egl.EGLDisplay

class RegisterActivity : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var password : EditText
    lateinit var name : EditText
    lateinit var mobileNo : EditText
    lateinit var gender : RadioGroup
    lateinit var signUp : Button
    lateinit var signIn : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        supportActionBar?.title = "Registration"

        signIn = findViewById(R.id.signIn)
        email = findViewById(R.id.email)
        password = findViewById(R.id.passwordAcc)
        name = findViewById(R.id.name)
        mobileNo = findViewById(R.id.mobileNo)
        gender = findViewById(R.id.gender)
        signUp = findViewById(R.id.signUp)

        signUp.setOnClickListener {
            if(name.text.toString().isEmpty()){
                name.error = "It is mandatory to fill in name"
            }else if(email.text.toString().isEmpty()){
                email.error = "It is mandatory to fill in email"
            }else if(password.text.toString().isEmpty()){
                password.error = "It is mandatory to fill in password"
            }else if(password.text.length < 8){
                password.error = "Password must be of 8 characters"
            }else if(mobileNo.text.toString().isEmpty()){
                mobileNo.error = "It is mandatory to fill in Mobile No"
            }else if(mobileNo.text.toString().length < 10){
                mobileNo.error = "Mobile No must be 10 digits"
            }else if(gender.checkedRadioButtonId == -1){
                Toast.makeText(this,"It is mandatory to choose gender",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Account has created successfully",Toast.LENGTH_LONG).show()
            }
        }

        signIn.setOnClickListener {
            var intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }


    }


}