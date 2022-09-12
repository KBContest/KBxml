/*콘텐츠_2 환수 스토리*/
package com.example.kb

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.kb.databinding.FragmentContentsStoryBinding

class ContentsStoryFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    // Inflate the layout for this fragment
        val bind = FragmentContentsStoryBinding.inflate(layoutInflater)

        bind.contentsStoryTitleBtn1.setOnClickListener {
            val intent = Intent(this@ContentsStoryFragment.requireContext(),ContentsStoryDetailActivity::class.java)
            startActivity(intent)
        }

    // 리스트 버튼을 눌렀을때 리스트뷰 액티비티로 이동
        bind.contentsStoryListBtn.setOnClickListener {
            val intent_list = Intent(context, ContentsStoryListActivity::class.java)
            startActivity(intent_list)
        }
        return bind.root
    }

}