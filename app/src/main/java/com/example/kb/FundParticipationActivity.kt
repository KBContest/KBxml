package com.example.kb

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kb.databinding.ActivityFundParticipationBinding
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class FundParticipationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFundParticipationBinding
    private var fundId = 0
    private var percent = 0
    private val dateFormat = SimpleDateFormat("yyyyMMdd")
    private var endDay: Long = 0
    private var today: Long = 0
    private var dDay: Long = 0
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFundParticipationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (intent.hasExtra("fundId")) {
            fundId = intent.getIntExtra("fundId", 0)
        }

        dbRef = FirebaseDatabase.getInstance().getReference("test")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    // val modelResult = snapshot.getValue(CulturalHeritage::class.java)
                    val modelResult = snapshot.child(fundId.toString()).getValue(CulturalHeritage::class.java)

                    binding.partCountry.text = modelResult!!.country + " 반출"
                    binding.partTitle.text = modelResult!!.title
                    binding.partSubTitle.text = modelResult!!.introShortEdit
                    binding.partMoney.text = modelResult!!.currentAmount.toString()
                    percent = (modelResult!!.currentAmount.toDouble() / modelResult!!.targetAmount * 100).toInt()
                    binding.partProgressBar.setProgress(percent)
                    binding.partProgressPercent.text = "${percent}%"
                    binding.partGoalMoney.text = modelResult!!.targetAmount.toString()
                    binding.partPeriod.text = "${modelResult!!.startDay} ~ ${modelResult!!.endDay}"
                    endDay = dateFormat.parse(modelResult!!.endDay).time
                    today = Calendar.getInstance().apply {
                        set(Calendar.HOUR_OF_DAY, 0)
                        set(Calendar.MINUTE, 0)
                        set(Calendar.SECOND, 0)
                        set(Calendar.MILLISECOND, 0)
                    }.time.time
                    dDay = (endDay - today) / (24 * 60 * 60 * 1000)
                    if (dDay.toInt() > 0) {
                        binding.remainderPeriod.text = "${dDay}일 남음"
                    }
                    else if (dDay.toInt() == 0) {
                        binding.remainderPeriod.text = "오늘 마감"
                    }
                    else {
                        binding.remainderPeriod.text = "모금 종료"
                        binding.partBtn.text = "모금 종료"
                        binding.partBtn.isClickable = false
                    }
                    val storageRef = FirebaseStorage.getInstance().reference.child("test/$fundId.jpg")
                    val localFile = File.createTempFile("tempImage", "jpg")
                    storageRef.getFile(localFile).addOnSuccessListener {
                        val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                        binding.projectItemImage.setImageBitmap(bitmap)
                    }
                    binding.projectItemNameKr.text = modelResult!!.projectName
                    binding.projectItemIntro.text = modelResult!!.introEdit
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        binding.partBtn.setOnClickListener {
            val intent = Intent(this, FundParticipationActivity2::class.java)
            intent.putExtra("fundId", fundId)
            intent.putExtra("title", binding.partTitle.text)
            intent.putExtra("currentAmount", binding.partMoney.text)
            intent.putExtra("percent", binding.partProgressPercent.text)
            intent.putExtra("dDay", binding.remainderPeriod.text)
            startActivity(intent)
        }

        binding.partBackBtn.setOnClickListener {
            val intent = Intent(this, FundFragment::class.java)
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            finish()
        }
    }
}