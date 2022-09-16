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
    var fundIdList = arrayListOf<Int>()
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
                            modelResult!!.fundId,
                            modelResult!!.country,
                            modelResult!!.title,
                            modelResult!!.targetAmount,
                            modelResult!!.currentAmount,
                            modelResult!!.endDay)

                        fundIdList.add(modelResult!!.fundId)

                        // data.key!!.toInt()
                    }
                }

                (adapter as CulturalHeritageAdapter).notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

        // 모금 리스트 클릭
        listView.isClickable = true
        listView.setOnItemClickListener { adapterView, view, i, l ->
            activity?.let {
                val intent = Intent(context, FundParticipationActivity::class.java)
                intent.putExtra("fundId", fundIdList[i])
                startActivity(intent)
            }
        }

        // 모금 생성 버튼 클릭
        fundraiserBtn = view.findViewById<ImageButton>(R.id.fundraiser_btn)
        fundraiserBtn.setOnClickListener {
            if (!fundIdList.isEmpty())
                fundId = fundIdList.last()
            activity?.let {
                val intent = Intent(context, FundOpenActivity::class.java)
                intent.putExtra("fundId", fundId)
                startActivity(intent)
            }
        }

        return view
    }
}