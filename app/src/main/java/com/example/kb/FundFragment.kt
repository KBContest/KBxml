/*모금 개설_1*/
package com.example.kb

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import com.google.firebase.database.*

class FundFragment() : Fragment() {
    private lateinit var dbRef: DatabaseReference
    private lateinit var adapter: Adapter
    private lateinit var listView: ListView
    private var fundId = 0
    private lateinit var fundraiserBtn: ImageButton

    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_fund, container, false)

        adapter = CulturalHeritageAdapter(container!!.context)
        listView = view.findViewById<ListView>(R.id.fund_listView)
        listView.adapter = adapter as CulturalHeritageAdapter

        dbRef = FirebaseDatabase.getInstance().getReference("test")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (data in snapshot.children) {
                        val modelResult = data.getValue(CulturalHeritage::class.java)

                        (adapter as CulturalHeritageAdapter).addItem(
                            data.key!!.toInt(),
                            modelResult!!.country,
                            modelResult!!.title,
                            modelResult!!.targetAmount,
                            modelResult!!.currentAmount)

                        fundId++
                    }
                }

                (adapter as CulturalHeritageAdapter).notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        fundraiserBtn = view.findViewById<ImageButton>(R.id.fundraiser_btn)
        fundraiserBtn.setOnClickListener {
            activity?.let {
                val intent = Intent(context, FundOpenActivity::class.java)
                intent.putExtra("fundId", fundId)
                startActivity(intent)
            }
        }

        return view
    }

    /*
    private fun getData() {
        dbRef = FirebaseDatabase.getInstance().getReference("CulturalHeritage")

        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if (snapshot.exists()) {
                    for (data in snapshot.children) {
                        val modelResult = data.getValue(CulturalHeritage::class.java)

                        adapter.addItem(
                            data.key!!.toInt(),
                            modelResult!!.country,
                            modelResult!!.title,
                            modelResult!!.targetMoney,
                            modelResult!!.currentMoney)
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
     */
}