/*콘텐츠_2 문화재*/
package com.example.kb

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kb.databinding.FragmentContentsCultureBinding
import com.example.kb.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_contents_culture.*


class ContentsCultureFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    // Inflate the layout for this fragment

        val bind = FragmentContentsCultureBinding.inflate(layoutInflater)

        bind.contentsCultureTitleBtn1.setOnClickListener {
            val intent = Intent(this@ContentsCultureFragment.requireContext(),ContentsStoryDetailActivity::class.java)
            startActivity(intent)
        }

    // 리스트 버튼을 눌렀을때 리스트뷰 액티비티로 이동
        bind.contentsCultureListBtn.setOnClickListener {
            val intent_list = Intent(context, ContentsStoryListActivity::class.java)
            startActivity(intent_list)
        }
        return bind.root
    }

}