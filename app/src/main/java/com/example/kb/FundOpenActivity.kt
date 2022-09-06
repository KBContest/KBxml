/*모금 개설_2*/
package com.example.kb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.lang.Exception

class FundOpenActivity : AppCompatActivity() {
    private var fundId = 0
    private lateinit var title: String
    private lateinit var country: String
    private lateinit var introEdit: String
    private lateinit var introShortEdit: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fund_open)

        // 앞의 페이지(FundFragmetn)에서 데이터 인수
        fundId = intent.getIntExtra("fundId", 0)
        println(fundId)

        // 현재 페이지 데이터
        val fund_open_title_edit = findViewById<EditText>(R.id.fund_open_title_edit)
        title = fund_open_title_edit.text.toString()

        val country_j_btn = findViewById<Button>(R.id.country_j_btn)
        country_j_btn.setOnClickListener {
            country = "일본"
        }
        val country_c_btn = findViewById<Button>(R.id.country_c_btn)
        country_c_btn.setOnClickListener {
            country = "중국"
        }
        val country_f_btn = findViewById<Button>(R.id.country_f_btn)
        country_f_btn.setOnClickListener {
            country = "프랑스"
        }
        val country_u_btn = findViewById<Button>(R.id.country_u_btn)
        country_u_btn.setOnClickListener {
            country = "미국"
        }
        val country_g_btn = findViewById<Button>(R.id.country_g_btn)
        country_g_btn.setOnClickListener {
            country = "독일"
        }
        val country_r_btn = findViewById<Button>(R.id.country_r_btn)
        country_r_btn.setOnClickListener {
            country = "러시아"
        }

        val project_intro_edit = findViewById<EditText>(R.id.project_intro_edit)
        introEdit = project_intro_edit.text.toString()

        val project_intro_short_edit = findViewById<EditText>(R.id.project_intro_short_edit)
        introShortEdit = project_intro_short_edit.text.toString()

        val fund_next_btn = findViewById<Button>(R.id.fund_next_btn)
        fund_next_btn.setOnClickListener {
            try {
                val intent = Intent(this, FundOpenActivity2::class.java)
                intent.putExtra("fundId", fundId)
                intent.putExtra("title", title)
                intent.putExtra("country", country)
                intent.putExtra("introEdit", introEdit)
                intent.putExtra("introShortEdit", introShortEdit)
                startActivity(intent)
                // finish()
            }
            catch (e: Exception) {
                Toast.makeText(this, "모든 정보를 입력해 주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}