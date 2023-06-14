package com.ramanmatharu.loginwindow

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged

class GenerateOtpActivity : AppCompatActivity() {

    var mail = ""
    var otp = ""
    lateinit var cameMail: TextView
    lateinit var numOne : EditText
    lateinit var numTwo : EditText
    lateinit var numThree : EditText
    lateinit var numFour : EditText
    lateinit var verifyBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generate_otp)

        supportActionBar?.title = "Back"

        intent?.extras?.let{
            mail = it.getString("mail","")
        }

        cameMail = findViewById(R.id.cameMail)
        cameMail.setText(mail)

        numOne = findViewById(R.id.numOne)
        numTwo = findViewById(R.id.numTwo)
        numThree = findViewById(R.id.numThree)
        numFour = findViewById(R.id.numFour)
        verifyBtn = findViewById(R.id.verifyBtn)


        numOne.doOnTextChanged { text, start, before, count ->
            if((text?.length?:0) > 0){
                numTwo.requestFocus()
            }
        }

        numTwo.doOnTextChanged { text, start, before, count ->
            if((text?.length?:0)>0){
                numThree.requestFocus()
            }
        }

        numThree.doOnTextChanged { text, start, before, count ->
            if((text?.length?:0)>0){
                numFour.requestFocus()
            }
        }




        verifyBtn.setOnClickListener {
            otp = numOne.text.toString() + numTwo.text.toString() + numThree.text.toString() +
                    numFour.text.toString()
            if((otp.length)<4){
                Toast.makeText(this,"Otp is not complete",Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this,ResetPasswordActivity::class.java)
                startActivity(intent)
            }
        }
    }
}