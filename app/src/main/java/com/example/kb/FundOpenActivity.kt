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
    private var fundId = 1
    private lateinit var title: String
    private lateinit var country: String
    private lateinit var introEdit: String
    private lateinit var introShortEdit: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fund_open)

        // 앞 페이지(FundFragment) 데이터 인수
        fundId = intent.getIntExtra("fundId", 0)
        println(fundId)

        // xml ID 연결
        val fund_open_title_edit = findViewById<EditText>(R.id.fund_open_title_edit)
        val country_j_btn = findViewById<Button>(R.id.country_j_btn)
        val country_c_btn = findViewById<Button>(R.id.country_c_btn)
        val country_f_btn = findViewById<Button>(R.id.country_f_btn)
        val country_u_btn = findViewById<Button>(R.id.country_u_btn)
        val country_g_btn = findViewById<Button>(R.id.country_g_btn)
        val country_r_btn = findViewById<Button>(R.id.country_r_btn)
        val project_intro_edit = findViewById<EditText>(R.id.project_intro_edit)
        val project_intro_short_edit = findViewById<EditText>(R.id.project_intro_short_edit)
        val fund_next_btn = findViewById<Button>(R.id.fund_next_btn)

        // 국가 선택
        country_j_btn.setOnClickListener {
            country = "일본"
        }
        country_c_btn.setOnClickListener {
            country = "중국"
        }
        country_f_btn.setOnClickListener {
            country = "프랑스"
        }
        country_u_btn.setOnClickListener {
            country = "미국"
        }
        country_g_btn.setOnClickListener {
            country = "독일"
        }
        country_r_btn.setOnClickListener {
            country = "러시아"
        }

        // 다음 페이지로 넘어가는 버튼 클릭
        fund_next_btn.setOnClickListener {
            try {
                title = fund_open_title_edit.text.toString()
                introEdit = project_intro_edit.text.toString()
                introShortEdit = project_intro_short_edit.text.toString()

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