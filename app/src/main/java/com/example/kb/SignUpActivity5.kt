/*회원가입_5*/
package com.example.kb

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sign_up5.*


class SignUpActivity5 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up5)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("nickname")

        contents_back_btn.setOnClickListener {
            val intent = Intent(this, SignUpActivity4::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.complete_btn).setOnClickListener {
            myRef.setValue(editTextName.text.toString())

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}