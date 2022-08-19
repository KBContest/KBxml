/*콘텐츠 뷰페이저 어댑터*/
package com.example.kb

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewFragmentAdatper(fm: FragmentManager, lifecycle: Lifecycle): FragmentStateAdapter(fm, lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> ContentsStoryFragment()
            1 -> ContentsCultureFragment()
            else -> ContentsStoryFragment()
        }
    }

}