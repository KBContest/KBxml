package com.example.kb

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_qa2.*


class QaActivity2: AppCompatActivity() {

    val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("/information/nickname")
    val database2: DatabaseReference = FirebaseDatabase.getInstance().getReference("/information/question")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qa2)

        val menuListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value: String = dataSnapshot.value.toString()
                qna_name2_new.text = value
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        }
        val menuListener2 = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val value: String = dataSnapshot.value.toString()
                qna_q2_new.text = "Q. $value"
            }

            override fun onCancelled(error: DatabaseError) {
                println("Not yet implemented")
            }
        }
        database.addListenerForSingleValueEvent(menuListener)
        database2.addListenerForSingleValueEvent(menuListener2)

        qna_a_btn2.setOnClickListener {
            val intent = Intent(this, QaActivity3::class.java)
            startActivity(intent)
        }

        go_fund_btn.setOnClickListener {
            val intent = Intent(this,FundFragment::class.java)
            startActivity(intent)
        }

        qna_editText.addTextChangedListener(object: TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                qna_text_count.text = "0 / 150"
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var userinput =  qna_editText.text.toString()
                qna_text_count.text = userinput.length.toString() + " / 150"
            }

            override fun afterTextChanged(s: Editable?) {
                var userinput = qna_editText.text.toString()
                qna_text_count.text = userinput.length.toString() + " / 150"
            }

        })
    }

}