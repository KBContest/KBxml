/*모금 개설_1*/
package com.example.kb

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ListView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.google.firebase.database.*

class FundFragment() : Fragment() {
    private lateinit var dbRef: DatabaseReference
    private lateinit var adapter: Adapter
    private lateinit var listView: ListView

    constructor(parcel: Parcel) : this() {
    }

    override fun onCreate(savedInstanceState: Bundle?){
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
                            modelResult!!.targetMoney,
                            modelResult!!.currentMoney)
                    }
                }
                (adapter as CulturalHeritageAdapter).notifyDataSetChanged()
            }
            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
        listView.setOnItemClickListener{ adapterView: AdapterView<*>, view1: View, i: Int, l: Long ->
            // 눌린 위치에 해당하는 목록이 어떤 목록인지 가져오기
            val clickedList = CulturalHeritageAdapter.culturalHeritageList2
        }


        return view
    }

    // 리스트뷰의 일정 항목을 눌렀을 떄 다음 액티비티로 이동하는 코드
    fun setupEvents(){

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