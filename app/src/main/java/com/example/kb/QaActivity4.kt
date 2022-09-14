package com.example.kb

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_qa3.*
import kotlinx.android.synthetic.main.activity_qa3.qna_back_btn
import kotlinx.android.synthetic.main.activity_qa4.*


class QaActivity4 : AppCompatActivity() {
    val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("nickname")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qa4)

        val menuListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val user: String = dataSnapshot.value.toString()
                qna_name3.text= user
            }

            override fun onCancelled(error: DatabaseError) {
                //handle error
            }
        }
        database.addListenerForSingleValueEvent(menuListener)

        val intent: Intent = intent
        val answer:String? = intent.getStringExtra("answer")
        qna_a3.text="A. $answer"

        qna_back_btn.setOnClickListener{
            val intent2 = Intent(this, QaActivity2::class.java)
            startActivity(intent2)
        }

    }
}