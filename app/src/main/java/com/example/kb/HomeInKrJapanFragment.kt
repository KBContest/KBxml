/*메인_일본_돌아온 문화재*/
package com.example.kb

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kb.databinding.FragmentContentsStoryBinding
import com.example.kb.databinding.FragmentHomeInKrJapanBinding
import kotlinx.android.synthetic.main.fragment_home_in_kr_japan.*

class HomeInKrJapanFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val bind = FragmentHomeInKrJapanBinding.inflate(layoutInflater)

        // 귀면문마루끝기와 이미지 버튼을 눌렀을 때 상세페이지로 이동
        bind.inItemImage1.setOnClickListener {
            val intent1 = Intent(this@HomeInKrJapanFragment.requireContext(),HomeJapanDetailActivity2::class.java)
            startActivity(intent1)
        }
        // 녹유골호 이미지 버튼을 눌렀을 때 상세페이지로 이동
        bind.inItemImage2.setOnClickListener {
            val intent2 = Intent(this@HomeInKrJapanFragment.requireContext(),HomeJapanDetailActivity3::class.java)
            startActivity(intent2)
        }
        //정조 필 국화도 이미지 버튼을 눌렀을 때 상세페이지로 이동
        bind.inItemImage3.setOnClickListener {
            val intent3 = Intent(this@HomeInKrJapanFragment.requireContext(),HomeJapanDetailActivity::class.java)
            startActivity(intent3)
        }
        // 이선제 묘지 이미지 버튼을 눌렀을 때 상세페이지로 이동
        bind.inItemImage4.setOnClickListener {
            val intent4 = Intent(this@HomeInKrJapanFragment.requireContext(),ContentsStoryDetailActivity3::class.java)
            startActivity(intent4)
        }

        return bind.root
    }

}