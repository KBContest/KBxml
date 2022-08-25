/*메인 화면_2*/
package com.example.kb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.kb.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class HomeActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val tabTitleArray = arrayOf(
        "돌아온 문화재",
        "잃어버린 문화재"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pager = findViewById<ViewPager2>(R.id.main_viewPager2)
        val tab = findViewById<TabLayout>(R.id.main_tabLayout)

        pager.adapter = ContentsViewAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tab, pager) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }
}