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

        val uid = intent.getStringExtra("uid").toString()
        val email = intent.getStringExtra("email").toString()
        val pw = intent.getStringExtra("pw").toString()
        var hashMap = HashMap<String, Any>()
        val dbRef = FirebaseDatabase.getInstance().getReference("member")

        contents_back_btn.setOnClickListener {
            val intent = Intent(this, SignUpActivity4::class.java)
            startActivity(intent)
        }

        findViewById<Button>(R.id.complete_btn).setOnClickListener {
            hashMap.put("uid", uid)
            hashMap.put("email", email)
            hashMap.put("pw", pw)

            dbRef.child(uid).setValue(hashMap)

            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("uid", uid)
            startActivity(intent)
        }

    }
}