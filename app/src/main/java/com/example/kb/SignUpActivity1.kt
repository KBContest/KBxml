/*회원가입_1*/
package com.example.kb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUpActivity1 : AppCompatActivity() {

    lateinit var signupBtn: Button
    lateinit var googleBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up1)

        signupBtn = findViewById(R.id.sign_up_btn)
        googleBtn = findViewById(R.id.google_login_btn)
    }
}