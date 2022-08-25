/*회원가입_3*/
package com.example.kb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_sign_up2.*
import kotlinx.android.synthetic.main.activity_sign_up3.*
import kotlinx.android.synthetic.main.activity_sign_up2.editTextTextEmailAddress as editTextTextEmailAddress1

class SignUpActivity3 : AppCompatActivity() {
    var auth : FirebaseAuth? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up3)

        val editText = intent.getStringExtra("email")
        editTextTextEmailAddress3.setText(editText)

        contents_back_btn3.setOnClickListener() {
            val intent = Intent(this, SignUpActivity2::class.java)
            startActivity(intent)
        }

        next_btn3.setOnClickListener() {
            signinAndSignup()
            val intent = Intent(this, SignUpActivity4::class.java)
            val text = editTextTextEmailAddress3.text.toString()
            val text2 = editTextTextPassword.text.toString()

            intent.putExtra("email", text)
            intent.putExtra("pw", text2)
            startActivity(intent)

        }
    }
        fun signinAndSignup() {
            auth?.createUserWithEmailAndPassword(editTextTextEmailAddress3.text.toString(), editTextTextPassword.text.toString())
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        //Creating a user account
                    } else if (task.exception?.message.isNullOrEmpty()) {
                        //Show the error message
                        Toast.makeText(this, task.exception?.message, Toast.LENGTH_LONG).show()
                    }
                }
    }
}