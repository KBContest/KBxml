package com.example.kb

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kb.databinding.ActivityFundParticipationBinding
import com.example.kb.databinding.ActivityMainBinding
import com.google.firebase.database.*
import com.google.firebase.storage.FirebaseStorage
import java.io.File

class FundParticipationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFundParticipationBinding
    private var fundId = 0
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
                    binding.partGoalMoney.text = modelResult!!.targetAmount.toString()
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
            startActivity(intent)
        }
    }
}