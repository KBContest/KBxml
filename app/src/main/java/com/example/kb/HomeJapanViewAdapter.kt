/*메인 일본 뷰페이저 어댑터*/
package com.example.kb

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class HomeJapanViewAdapter (fm: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeInKrJapanFragment()
            1 -> HomeOutKrJapanFragment()
            else -> HomeInKrJapanFragment()
        }
    }
}