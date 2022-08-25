/*회원가입_4*/
package com.example.kb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import kotlinx.android.synthetic.main.activity_sign_up3.*
import kotlinx.android.synthetic.main.activity_sign_up4.*

class SignUpActivity4 : AppCompatActivity() {

    lateinit var next_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up4)

        val editEmail = intent.getStringExtra("email")
        editTextTextEmailAddress.setText(editEmail)
        val editPw = intent.getStringExtra("pw")
        editTextTextPassword2.setText(editPw)

        contents_back_btn4.setOnClickListener(){
            val intent = Intent(this, SignUpActivity3::class.java)
            startActivity(intent)
        }

        next_btn4.setOnClickListener {
            val intent = Intent(this, SignUpActivity5::class.java)
            startActivity(intent)
        }


    }
}