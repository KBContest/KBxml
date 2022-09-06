/*모금 개설_3*/
package com.example.kb

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    private var targetAmount: Int? = 0
    private var currentAmount = 0
    private var formatDate = SimpleDateFormat("dd MM YYYY", Locale.US)
    private lateinit var startDay: String
    private lateinit var endDay: String
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fund_open2)

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

        // 앞의 페이지(FundOpenActivity)에서 데이터 인수
        /*
        fundId = intent.getIntExtra("fundId", 0)
        title = intent.getStringExtra("title").toString()
        country = intent.getStringExtra("country").toString()
        introEdit = intent.getStringExtra("introEdit").toString()
        introShortEdit = intent.getStringExtra("introShortEdit").toString()
         */

        // 현재 페이지 데이터
        val target_amount_edit = findViewById<EditText>(R.id.target_amount_edit)
        targetAmount = target_amount_edit.text.toString().toInt()

        // DatePickerDialog를 사용하여 시작일 및 종료일 선택
        val start_day_edit = findViewById<EditText>(R.id.start_day_edit)
        val end_day_edit = findViewById<EditText>(R.id.end_day_edit)

        start_day_edit.setOnClickListener {
            val getDate: Calendar = Calendar.getInstance()
            val datePicker = DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                val selectDate: Calendar = Calendar.getInstance()
                selectDate.set(Calendar.YEAR, i)
                selectDate.set(Calendar.MONTH, i2)
                selectDate.set(Calendar.DAY_OF_MONTH, i3)

                startDay = formatDate.format(selectDate.time)

            }, getDate.get(Calendar.YEAR), getDate.get(Calendar.MONTH), getDate.get(Calendar.DAY_OF_MONTH))
            datePicker.show()
        }

        start_day_edit.setOnClickListener {
            val getDate: Calendar = Calendar.getInstance()
            val datePicker = DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                val selectDate: Calendar = Calendar.getInstance()
                selectDate.set(Calendar.YEAR, i)
                selectDate.set(Calendar.MONTH, i2)
                selectDate.set(Calendar.DAY_OF_MONTH, i3)

                startDay = formatDate.format(selectDate.time)
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
                end_day_edit.setText(endDay)
            }, getDate.get(Calendar.YEAR), getDate.get(Calendar.MONTH), getDate.get(Calendar.DAY_OF_MONTH))
            datePicker.show()
        }

        // Firebase에 데이터 추가
        dbRef = FirebaseDatabase.getInstance().getReference("test")
        val fund = Fund(fundId, title, country, introEdit, introShortEdit, targetAmount!!, currentAmount, startDay, endDay)
        dbRef.child(fundId.toString()).setValue(fund).addOnSuccessListener {
            Toast.makeText(this, "Successfully Saved", Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this, "Failed", Toast.LENGTH_SHORT).show()
        }
    }
}