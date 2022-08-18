/*콘텐츠_1*/
package com.example.kb

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ContentsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_contents, container, false)
        val pager:ViewPager2 = view.findViewById(R.id.viewPager2)
        val tab:TabLayout = view.findViewById(R.id.tabLayout)

        pager.adapter = ViewFragmentAdatper(childFragmentManager, lifecycle)

        TabLayoutMediator(tab, pager){ tab, position ->
            when(position){
                0->{
                    tab.text = "환수 스토리"
                }
                1->{
                    tab.text = "문화재"
                }
            }
        }.attach()

        return view
    }
}