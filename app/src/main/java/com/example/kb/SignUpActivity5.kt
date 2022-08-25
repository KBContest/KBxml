/*회원가입_5*/
package com.example.kb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_sign_up3.*
import kotlinx.android.synthetic.main.activity_sign_up5.*

class SignUpActivity5 : AppCompatActivity() {

    lateinit var next_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up5)

        contents_back_btn5.setOnClickListener(){
            val intent = Intent(this, SignUpActivity4::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.complete_btn).setOnClickListener {
            val intent = Intent(this, SignUpActivity6::class.java)
            startActivity(intent)
        }
    }
}