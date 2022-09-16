package com.example.kb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kb.databinding.ActivityFundParticipation2Binding

class FundParticipationActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityFundParticipation2Binding
    private var fundId = 0
    private lateinit var title: String
    private lateinit var currentAmount: String
    private lateinit var percent: String
    private lateinit var dDay: String
    private var partAmount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFundParticipation2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("fundId")) {
            fundId = intent.getIntExtra("fundId", 0)
        }

        if (intent.hasExtra("title")) {
            title = intent.getStringExtra("title").toString()
        }

        if (intent.hasExtra("currentAmount")) {
            currentAmount = intent.getStringExtra("currentAmount").toString()
        }

        if (intent.hasExtra("percent")) {
            percent = intent.getStringExtra("percent").toString()
        }

        if (intent.hasExtra("dDay")) {
            dDay = intent.getStringExtra("dDay").toString()
        }

        binding.builderNameCheck.setOnClickListener {
            binding.builderNameCheck.isSelected = !binding.builderNameCheck.isSelected
        }

        binding.builderAmountCheck.setOnClickListener {
            binding.builderAmountCheck.isSelected = !binding.builderAmountCheck.isSelected
        }

        binding.partNextBtn.setOnClickListener {
            try {
                partAmount = binding.partAmountEdit.text.toString().toInt()

                val intent = Intent(this, FundParticipationActivity3::class.java)
                intent.putExtra("fundId", fundId)
                intent.putExtra("title", title)
                intent.putExtra("currentAmount", currentAmount)
                intent.putExtra("percent", percent)
                intent.putExtra("dDay", dDay)
                intent.putExtra("partAmount", partAmount)
                intent.putExtra("nameCheck", binding.builderNameCheck.isSelected)
                intent.putExtra("amountCheck", binding.builderAmountCheck.isSelected)
                startActivity(intent)
            }
            catch (e: Exception) {
                Toast.makeText(this, "모든 정보를 입력해 주세요.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.partBackBtn.setOnClickListener {
            val intent = Intent(this, FundParticipationActivity::class.java)
            startActivity(intent)
        }
    }
}