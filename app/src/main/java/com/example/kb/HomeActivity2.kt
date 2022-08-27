/*메인 화면_2*/
package com.example.kb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity2 : AppCompatActivity() {

    var tabTitle = arrayOf("돌아온 문화재", "잃어버린 문화재")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)

        var tab = findViewById<TabLayout>(R.id.home_tabLayout)
        var pager = findViewById<ViewPager2>(R.id.home_viewPager2)

        pager.adapter = HomeViewAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tab, pager){
            tab, position -> tab.text = tabTitle[position]
        }.attach()
    }
}