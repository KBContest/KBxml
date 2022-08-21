/*모금 개설_1*/
package com.example.kb

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class FundFragment() : Fragment(){
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
        val pager: ViewPager2 = view.findViewById(R.id.fund_viewPager2)
        val tab: TabLayout = view.findViewById(R.id.fund_tabLayout)

        pager.adapter = FundViewAdapter(childFragmentManager, lifecycle)

        TabLayoutMediator(tab, pager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "홈"
                }
                1 -> {
                    tab.text = "인기"
                }
                2-> {
                    tab.text = "신규"
                }
                3-> {
                    tab.text = "마감임박"
                }
            }
        }.attach()

        return view

    }
}