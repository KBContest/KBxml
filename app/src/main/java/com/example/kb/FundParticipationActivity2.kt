package com.example.kb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kb.databinding.ActivityFundParticipation2Binding

class FundParticipationActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityFundParticipation2Binding
    private var partAmount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFundParticipation2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.builderNameCheck.setOnClickListener {
            binding.builderNameCheck.isSelected = !binding.builderNameCheck.isSelected
        }

        binding.builderAmountCheck.setOnClickListener {
            binding.builderAmountCheck.isSelected = !binding.builderAmountCheck.isSelected
        }

        binding.partNextBtn.setOnClickListener {
            partAmount = binding.partAmountEdit.toString().toInt()

            val intent = Intent(this, FundParticipationActivity3::class.java)
            intent.putExtra("partAmount", partAmount)
            intent.putExtra("nameCheck", binding.builderNameCheck.isSelected)
            intent.putExtra("amountCheck", binding.builderAmountCheck.isSelected)
            startActivity(intent)
        }
    }
}