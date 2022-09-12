/*콘텐츠_3 문화재 리스트*/
package com.example.kb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contents_culture_list.*
import kotlinx.android.synthetic.main.activity_contents_story_list.*

class ContentsCultureListActivity : AppCompatActivity() {

    // push test.
    val mContentsCultureList = ArrayList<ContentsCultureListModels>()
    lateinit var mContentsCultureListAdapter: ContentsCultureListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contents_culture_list)

        setupEvents()
        setValues()
    }


    fun setupEvents() {

        //메인화면의 이벤트관련 코드를 모아두는 곳
        // 리스트 클릭 이벤트 - 리스트뷰의 각 줄마다 눌렸을때 구동하는 이벤트
        contents_culture_list.setOnItemClickListener { adapterView, view, i, l ->

            // 누른 위치에 해당하는 목록이 어떤 목록인가
            val clickedList = mContentsCultureList[i]
            // 선택된 목록의 정보를 가져왔다면 화면 이동
            val myIntent = Intent(this, ContentsListCustomActivity::class.java)
            // 정보를 담아주기
            // 화면 전환
            if(i==0){
                startActivity(Intent(this@ContentsCultureListActivity, ContentsStoryDetailActivity::class.java))
            }
        }
    }

    fun setValues() {
        // 각각의 리스트 한 줄 추가
        mContentsCultureList.add(ContentsCultureListModels("망국의 옹주, 덕혜옹주의 스란치마",""))
        mContentsCultureList.add(ContentsCultureListModels("다섯개의 산봉우리, 일월오봉도",""))
        mContentsCultureList.add(ContentsCultureListModels("어보를 품은 상자, 보록",""))
        mContentsCultureList.add(ContentsCultureListModels("빼어나게 아름다운 금강산, 금강내산전도",""))
        mContentsCultureList.add(ContentsCultureListModels("문신들의 뱃놀이를 그린, 독서당 계회도",""))
        mContentsCultureList.add(ContentsCultureListModels("검은 옻칠과 영롱한 자개 장식, 나전 칠기",""))
        mContentsCultureList.add(ContentsCultureListModels("고종의 국새, 국새 황제지보",""))
        mContentsCultureList.add(ContentsCultureListModels("조선시대 왕들의 글씨를 탁본한, 열성어필",""))

        // 어댑터 연결
        mContentsCultureListAdapter = ContentsCultureListAdapter(this, mContentsCultureList)
        contents_culture_list.adapter = mContentsCultureListAdapter

    }
}