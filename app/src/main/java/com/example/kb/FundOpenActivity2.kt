/*모금 개설_3*/
package com.example.kb

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.*
import java.text.SimpleDateFormat
import java.util.*

class FundOpenActivity2 : AppCompatActivity() {
    private var fundId = 0
    private lateinit var title: String
    private lateinit var country: String
    private lateinit var introEdit: String
    private lateinit var introShortEdit: String
    private var targetAmount = 0
    private var currentAmount = 0
    private var formatDate = SimpleDateFormat("dd MM YYYY", Locale.US)
    private lateinit var startDay: String
    private lateinit var endDay: String
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fund_open2)

        // 앞 페이지(FundFragment) 데이터 인수
        if (intent.hasExtra("fundId")) {
            fundId = intent.getIntExtra("fundId", 0)
        }
        if (intent.hasExtra("title")) {
            title = intent.getStringExtra("title").toString()
        }
        if (intent.hasExtra("country")) {
            country = intent.getStringExtra("country").toString()
        }
        if (intent.hasExtra("introEdit")) {
            introEdit = intent.getStringExtra("introEdit").toString()
        }
        if (intent.hasExtra("introShortEdit")) {
            introShortEdit = intent.getStringExtra("introShortEdit").toString()
        }

        // xml ID 연결
        val target_amount_edit = findViewById<EditText>(R.id.target_amount_edit)
        val start_day_edit = findViewById<EditText>(R.id.start_day_edit)
        val end_day_edit = findViewById<EditText>(R.id.end_day_edit)

        // DatePickerDialog를 사용하여 시작일 및 종료일 선택
        start_day_edit.setOnClickListener {
            val getDate: Calendar = Calendar.getInstance()
            val datePicker = DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                val selectDate: Calendar = Calendar.getInstance()
                selectDate.set(Calendar.YEAR, i)
                selectDate.set(Calendar.MONTH, i2)
                selectDate.set(Calendar.DAY_OF_MONTH, i3)

                startDay = formatDate.format(selectDate.time)
                println(startDay)
                start_day_edit.setText(startDay)
            }, getDate.get(Calendar.YEAR), getDate.get(Calendar.MONTH), getDate.get(Calendar.DAY_OF_MONTH))
            datePicker.show()
        }

        end_day_edit.setOnClickListener {
            val getDate: Calendar = Calendar.getInstance()
            val datePicker = DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                val selectDate: Calendar = Calendar.getInstance()
                selectDate.set(Calendar.YEAR, i)
                selectDate.set(Calendar.MONTH, i2)
                selectDate.set(Calendar.DAY_OF_MONTH, i3)

                endDay = formatDate.format(selectDate.time)
                println(endDay)
                end_day_edit.setText(endDay)
            }, getDate.get(Calendar.YEAR), getDate.get(Calendar.MONTH), getDate.get(Calendar.DAY_OF_MONTH))
            datePicker.show()
        }

        // 모금 시작으로 넘어가는 버튼 클릭 (Firebase에 데이터 추가)
        val fund_end_btn = findViewById<Button>(R.id.fund_end_btn)
        fund_end_btn.setOnClickListener {
            try {
                targetAmount = target_amount_edit.text.toString().toInt()

                dbRef = FirebaseDatabase.getInstance().getReference("test")
                val fund = Fund(fundId, title, country, introEdit, introShortEdit, targetAmount, currentAmount, startDay, endDay)
                println("--------")
                println(fundId)
                println(title)
                println(country)
                println(introEdit)
                println(introShortEdit)
                println(targetAmount)
                println(currentAmount)
                println(startDay)
                println(endDay)
                println("--------")
                dbRef.child(fundId.toString()).setValue(fund).addOnSuccessListener {
                    Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show()
                }.addOnFailureListener {
                    Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
                }
            }
            catch (e: Exception) {
                println(e)
                Toast.makeText(this, "모든 정보를 입력해 주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}