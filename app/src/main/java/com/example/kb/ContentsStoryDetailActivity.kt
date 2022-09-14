/*콘텐츠_4 환수 스토리 상세보기*/
package com.example.kb

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_contents_story_detail.*

class ContentsStoryDetailActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contents_story_detail)

        contents_story_webView.setBackgroundColor(Color.TRANSPARENT)

        contents_story_webView.apply{
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }
        // 웹뷰에 사용될 주소
        contents_story_webView.loadUrl("file:///android_asset/콘텐츠_덕혜옹주.html")

        // 질문하러가기 버튼 눌렀을 때 QnA로 이동
        go_contents_btn.setOnClickListener {
            val qnaFragment = QaFragment()
            val fragment : Fragment ?=
                supportFragmentManager.findFragmentByTag(QaFragment::class.java.simpleName)

            if(fragment !is QaFragment){
                supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainerView, qnaFragment, QaFragment::class.java.simpleName)
                    .commit()
            }
        }

        // 하단의 다른 버튼1을 눌렀을 때 화면 이동
        other_contents_btn1.setOnClickListener {
            startActivity(Intent(this@ContentsStoryDetailActivity, ContentsStoryDetailActivity3::class.java))
        }
        // 하단의 다른 버튼2을 눌렀을 때 화면 이동
        other_contents_btn2.setOnClickListener {
            startActivity(Intent(this@ContentsStoryDetailActivity, ContentsStoryDetailActivity2::class.java))
        }
    }
}