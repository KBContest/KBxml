package com.example.kb

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FundViewAdapter(fm: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> FundHomeFragment()
            1 -> FundBestFragment()
            2 -> FundNewFragment()
            3 -> FundEndFragment()
            else -> FundHomeFragment()
        }
    }

}