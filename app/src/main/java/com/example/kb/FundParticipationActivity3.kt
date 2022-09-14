package com.example.kb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kb.databinding.ActivityFundParticipation3Binding

class FundParticipationActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityFundParticipation3Binding
    private var partAmount = 0
    private var nameCheck = false
    private var amountCheck = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFundParticipation3Binding.inflate(layoutInflater)
        setContentView(binding.root)

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

        binding.finalPayAmount.text = partAmount.toString()
    }
}