/*메인화면_3_일본 상세보기*/
package com.example.kb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_contents_story_detail.*

class HomeJapanDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_japan_detail)

        contents_story_webView.apply{
            webViewClient = WebViewClient()
            settings.javaScriptEnabled = true
        }
        // 웹뷰에 사용될 주소
        contents_story_webView.loadUrl("file:///android_asset/몽유도원도 39360de558124054982fbb86b9ab91e5.html")
    }
}