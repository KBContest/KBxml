/*모금 개설_2*/
package com.example.kb

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_fund_open.*
import java.lang.Exception

class FundOpenActivity : AppCompatActivity() {
    private var fundId = 1
    private lateinit var title: String
    private lateinit var country: String
    private lateinit var introEdit: String
    private lateinit var introShortEdit: String
    private lateinit var imageUri: Uri
    private lateinit var projectName: String

    @SuppressLint("ResourceAsColor")
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
        val item_picture = findViewById<ImageView>(R.id.item_picture)
        val project_intro_name_edit = findViewById<EditText>(R.id.project_intro_name_edit)
        val fund_next_btn = findViewById<Button>(R.id.fund_next_btn)

        // 국가 선택
        country_j_btn.setOnClickListener {
            country = "일본"
            country_j_btn.isSelected = !country_j_btn.isSelected
            country_c_btn.isSelected = false
            country_f_btn.isSelected = false
            country_u_btn.isSelected = false
            country_g_btn.isSelected = false
            country_r_btn.isSelected = false
        }
        country_c_btn.setOnClickListener {
            country = "중국"
            country_c_btn.isSelected = !country_c_btn.isSelected
            country_j_btn.isSelected = false
            country_f_btn.isSelected = false
            country_u_btn.isSelected = false
            country_g_btn.isSelected = false
            country_r_btn.isSelected = false
        }
        country_f_btn.setOnClickListener {
            country = "프랑스"
            country_f_btn.isSelected = !country_f_btn.isSelected
            country_j_btn.isSelected = false
            country_c_btn.isSelected = false
            country_u_btn.isSelected = false
            country_g_btn.isSelected = false
            country_r_btn.isSelected = false
        }
        country_u_btn.setOnClickListener {
            country = "미국"
            country_u_btn.isSelected = !country_u_btn.isSelected
            country_j_btn.isSelected = false
            country_c_btn.isSelected = false
            country_f_btn.isSelected = false
            country_g_btn.isSelected = false
            country_r_btn.isSelected = false
        }
        country_g_btn.setOnClickListener {
            country = "독일"
            country_g_btn.isSelected = !country_g_btn.isSelected
            country_j_btn.isSelected = false
            country_c_btn.isSelected = false
            country_f_btn.isSelected = false
            country_u_btn.isSelected = false
            country_r_btn.isSelected = false
        }
        country_r_btn.setOnClickListener {
            country = "러시아"
            country_r_btn.isSelected = !country_r_btn.isSelected
            country_j_btn.isSelected = false
            country_c_btn.isSelected = false
            country_f_btn.isSelected = false
            country_u_btn.isSelected = false
            country_g_btn.isSelected = false
        }

        // 이미지 선택
        item_picture.setOnClickListener {
            selectImage()
        }

        // 다음 페이지로 넘어가는 버튼 클릭
        fund_next_btn.setOnClickListener {
            try {
                title = fund_open_title_edit.text.toString()
                introEdit = project_intro_edit.text.toString()
                introShortEdit = project_intro_short_edit.text.toString()
                projectName = project_intro_name_edit.text.toString()

                val intent = Intent(this, FundOpenActivity2::class.java)
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
                intent.addFlags(Intent.FLAG_GRANT_PERSISTABLE_URI_PERMISSION)
                intent.putExtra("fundId", fundId)
                intent.putExtra("title", title)
                intent.putExtra("country", country)
                intent.putExtra("introEdit", introEdit)
                intent.putExtra("introShortEdit", introShortEdit)
                intent.putExtra("imageUri", imageUri.toString())
                intent.putExtra("projectName", projectName)
                startActivity(intent)
                finish()
            }
            catch (e: Exception) {
                Toast.makeText(this, "모든 정보를 입력해 주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun selectImage() {
        val intent = Intent()
        intent.type = "image/"
        intent.action = Intent.ACTION_GET_CONTENT

        startActivityForResult(intent, 100)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && resultCode == RESULT_OK) {
            imageUri = data?.data!!
            item_picture.setImageURI(imageUri)
            println("1 : $imageUri")
        }
    }
}