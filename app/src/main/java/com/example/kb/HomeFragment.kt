/*메인 화면_1*/
package com.example.kb

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kb.databinding.FragmentHomeBinding
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        // 버튼 구분 및 상세 연결 페이지를 다르게 하기 위함
        var japan = false
        var america = false
        var german = false

        // val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        val bind = FragmentHomeBinding.inflate(layoutInflater)

        // main_btn = view.findViewById(R.id.main_btn)

        bind.japanCircle.setOnClickListener {
            main_btn.visibility = View.VISIBLE
            japan = true
        }
        bind.usCircle.setOnClickListener {
            main_btn.visibility = View.VISIBLE
            america = true
        }
        bind.germanyCircle.setOnClickListener {
            main_btn.visibility = View.VISIBLE
            german = true
        }

        main_btn.setOnClickListener{
            val intent_jp = Intent(context, HomeJapanActivity::class.java)
            val intent_us = Intent(context, HomeUsActivity::class.java)
            // val intent_gm = Intent(context, HomeActivity4::class.java)

            // 일본 텍스트 뷰 클릭 시 일본 환수 문화재 상세페이지로 이동
            if(japan == true){
                startActivity(intent_jp)
            }
            // 미국 텍스트 뷰 클릭 시 일본 환수 문화재 상세페이지로 이동
            else if(america == true){
                startActivity(intent_us)
            }
            // 독일 텍스트 뷰 클릭 시 일본 환수 문화재 상세페이지로 이동
            else if(german == true){
                //startActivity(intent_gm)
            }
        }

        bind.japanCircle.setOnClickListener {
            main_btn.visibility = View.VISIBLE
            japan = true
            america = false
            german = false
            it.isSelected = true
            bind.usCircle.isSelected = false
            bind.germanyCircle.isSelected = false
            bind.canadaCircle.isSelected = false
            bind.franceCircle.isSelected = false
            bind.ukCircle.isSelected = false

        }
        bind.usCircle.setOnClickListener {
            main_btn.visibility = View.VISIBLE
            japan = false
            america = true
            german = false
            it.isSelected = true
            bind.japanCircle.isSelected = false
            bind.germanyCircle.isSelected = false
            bind.canadaCircle.isSelected = false
            bind.franceCircle.isSelected = false
            bind.ukCircle.isSelected = false
        }
        bind.germanyCircle.setOnClickListener {
            main_btn.visibility = View.VISIBLE
            japan = false
            america = false
            german = true
            it.isSelected = true
            bind.japanCircle.isSelected = false
            bind.usCircle.isSelected = false
            bind.canadaCircle.isSelected = false
            bind.franceCircle.isSelected = false
            bind.ukCircle.isSelected = false
        }
        bind.canadaCircle.setOnClickListener {
            main_btn.visibility = View.INVISIBLE
            it.isSelected = true
            bind.japanCircle.isSelected = false
            bind.usCircle.isSelected = false
            bind.germanyCircle.isSelected = false
            bind.franceCircle.isSelected = false
            bind.ukCircle.isSelected = false
        }
        bind.franceCircle.setOnClickListener {
            main_btn.visibility = View.INVISIBLE
            it.isSelected = true
            bind.japanCircle.isSelected = false
            bind.usCircle.isSelected = false
            bind.germanyCircle.isSelected = false
            bind.canadaCircle.isSelected = false
            bind.ukCircle.isSelected = false
        }
        bind.ukCircle.setOnClickListener {
            main_btn.visibility = View.INVISIBLE
            it.isSelected = true
            bind.japanCircle.isSelected = false
            bind.usCircle.isSelected = false
            bind.germanyCircle.isSelected = false
            bind.canadaCircle.isSelected = false
            bind.franceCircle.isSelected = false
        }


        bind.mainBtn.setOnClickListener{
            val intent_jp = Intent(context, HomeJapanActivity::class.java)
            val intent_us = Intent(context, HomeUsActivity::class.java)
            val intent_gm = Intent(context, HomeGermanyActivity::class.java)

            // 일본 텍스트 뷰 클릭 시 일본 환수 문화재 상세페이지로 이동
            if(japan == true){
                startActivity(intent_jp)
            }
            // 미국 텍스트 뷰 클릭 시 일본 환수 문화재 상세페이지로 이동
            else if(america == true){
                startActivity(intent_us)
            }
            // 독일 텍스트 뷰 클릭 시 일본 환수 문화재 상세페이지로 이동
            else if(german == true){
                startActivity(intent_gm)
            }
        }

        return bind.root
    }
}