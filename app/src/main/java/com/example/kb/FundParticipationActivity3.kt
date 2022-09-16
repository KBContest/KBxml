package com.example.kb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kb.databinding.ActivityFundParticipation3Binding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class FundParticipationActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityFundParticipation3Binding
    private var fundId = 0
    private lateinit var title: String
    private lateinit var currentAmount: String
    private lateinit var percent: String
    private lateinit var dDay: String
    private var partAmount = 0
    private var nameCheck = false
    private var amountCheck = false
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFundParticipation3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("fundId")) {
            fundId = intent.getIntExtra("fundId", 0)
        }

        if (intent.hasExtra("title")) {
            title = intent.getStringExtra("title").toString()
            binding.partItemTitle.text = title
        }

        if (intent.hasExtra("currentAmount")) {
            currentAmount = intent.getStringExtra("currentAmount").toString()
            binding.partItemAmount.text = currentAmount
        }

        if (intent.hasExtra("percent")) {
            percent = intent.getStringExtra("percent").toString()
            binding.partItemPercent.text = percent
        }

        if (intent.hasExtra("dDay")) {
            dDay = intent.getStringExtra("dDay").toString()
            binding.partItemDay.text = dDay
        }

        if (intent.hasExtra("partAmount")) {
            partAmount = intent.getIntExtra("partAmount", 0)
        }

        if (intent.hasExtra("nameCheck")) {
            nameCheck = intent.getBooleanExtra("nameCheck", false)
        }

        if (intent.hasExtra("amountCheck")) {
            amountCheck = intent.getBooleanExtra("amountCheck", false)
        }

        if (nameCheck) {
            binding.partProfileInfoName2.text = "익명의 후원자"
        }
        else {

        }

        binding.partProfileInfoCheck.setOnClickListener {
            binding.partProfileInfoCheck.isSelected = !binding.partProfileInfoCheck.isSelected
        }

        binding.partPayWayCard.setOnClickListener {
            binding.partPayWayCard.isSelected = !binding.partPayWayCard.isSelected
            binding.partPayWayPay.isSelected = false
        }

        binding.partPayWayPay.setOnClickListener {
            binding.partPayWayPay.isSelected = !binding.partPayWayPay.isSelected
            binding.partPayWayCard.isSelected = false
        }

        binding.finalPayAmount.text = partAmount.toString()

        binding.partNextBtn.setOnClickListener {
            dbRef = FirebaseDatabase.getInstance().getReference("test")
            dbRef.child(fundId.toString()).child("currentAmount").setValue(partAmount + currentAmount.toInt())
            println(dbRef.child(fundId.toString()).child("currentAmount"))
            println("num : ${partAmount + currentAmount.toInt()}")

            val intent = Intent(this, FundParticipationActivity::class.java)
            startActivity(intent)
        }

        binding.partBackBtn.setOnClickListener {
            val intent = Intent(this, FundParticipationActivity2::class.java)
            startActivity(intent)
        }
    }
}