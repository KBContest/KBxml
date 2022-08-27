/*마이페이지_내 모금 프로젝트*/
package com.example.kb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MypageFundActivity : AppCompatActivity() {

    var tabTitle = arrayOf("참여", "개설")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mypage_fund)

        var tab = findViewById<TabLayout>(R.id.fund_tabLayout)
        var pager = findViewById<ViewPager2>(R.id.fund_viewPager2)

        pager.adapter = MyFundViewAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tab, pager){
                tab, position -> tab.text = tabTitle[position]
        }.attach()
    }
}