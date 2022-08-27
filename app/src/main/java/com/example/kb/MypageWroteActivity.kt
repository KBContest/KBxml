/*마이페이지_내가 쓴 글*/
package com.example.kb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MypageWroteActivity : AppCompatActivity() {

    var tabTitle = arrayOf("질문", "답변")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage_wrote)

        var tab = findViewById<TabLayout>(R.id.wrote_tabLayout)
        var pager = findViewById<ViewPager2>(R.id.wrote_viewPager2)

        pager.adapter = MyWroteViewAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tab, pager){
            tab, position -> tab.text = tabTitle[position]
        }.attach()
    }
}