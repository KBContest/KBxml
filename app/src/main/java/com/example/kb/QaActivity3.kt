package com.example.kb

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_qa2.*
import kotlinx.android.synthetic.main.activity_qa3.*

class QaActivity3:AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qa3)

        qna_a_edit_btn.setOnClickListener {
            val intent = Intent(this, QaActivity4::class.java)
            intent.putExtra("answer",qna_a_edit.text.toString())
            startActivity(intent)
        }

    }
}