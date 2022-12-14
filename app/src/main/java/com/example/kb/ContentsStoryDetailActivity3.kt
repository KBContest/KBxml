/*콘텐츠_4 환수 스토리 상세보기*/
package com.example.kb

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_contents_story_detail.*

class ContentsStoryDetailActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contents_story_detail3)

        contents_story_webView.setBackgroundColor(Color.TRANSPARENT)

        contents_story_webView.apply{
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }
        // 웹뷰에 사용될 주소
        contents_story_webView.loadUrl("file:///android_asset/콘텐츠_이선제 묘지.html")

        // 하단의 다른 버튼1을 눌렀을 때 화면 이동
        other_contents_btn1.setOnClickListener {
            startActivity(Intent(this@ContentsStoryDetailActivity3, ContentsStoryDetailActivity2::class.java))
        }

        // 하단의 다른 버튼2을 눌렀을 때 화면 이동
        other_contents_btn2.setOnClickListener {
            startActivity(Intent(this@ContentsStoryDetailActivity3, ContentsStoryDetailActivity::class.java))
        }
    }
}