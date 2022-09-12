/*콘텐츠_3 환수 스토리 리스트*/
package com.example.kb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_contents_story_list.*
import com.example.kb.ContentsListBtnAdapter.ListBtnClickListener

class ContentsStoryListActivity : AppCompatActivity() {

    val mContentsStoryList = ArrayList<ContentsStoryListModels>()
    lateinit var mContentsStoryListAdapter: ContentsStoryListAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contents_story_list)

        setupEvents()
        setValues()
    }

    fun setupEvents() {

        //메인화면의 이벤트관련 코드를 모아두는 곳
        // 리스트 클릭 이벤트 - 리스트뷰의 각 줄마다 눌렸을때 구동하는 이벤트
        contents_story_list.setOnItemClickListener { adapterView, view, i, l ->

            // 눌린 위치에 해당하는 목록이 어떤 목록인지 가져오기
            val clickedList = mContentsStoryList[i]
            // 정보를 담아주기
            // 화면 전환
            if(i == 0){
                startActivity(Intent(this@ContentsStoryListActivity, ContentsStoryDetailActivity::class.java))
            }else if(i == 1){
                startActivity(Intent(this@ContentsStoryListActivity, ContentsStoryDetailActivity2::class.java))
            }else if(i == 2){
                startActivity(Intent(this@ContentsStoryListActivity, ContentsStoryDetailActivity3::class.java))
            }
        }
    }

    fun setValues() {
        // 각각의 리스트 한 줄 추가
        mContentsStoryList.add(ContentsStoryListModels("망국의 옹주, 덕혜옹주의 스란치마",""))
        mContentsStoryList.add(ContentsStoryListModels("다섯개의 산봉우리, 일월오봉도",""))
        mContentsStoryList.add(ContentsStoryListModels("어보를 품은 상자, 보록",""))
        mContentsStoryList.add(ContentsStoryListModels("빼어나게 아름다운 금강산, 금강내산전도",""))
        mContentsStoryList.add(ContentsStoryListModels("문신들의 뱃놀이를 그린, 독서당 계회도",""))
        mContentsStoryList.add(ContentsStoryListModels("검은 옻칠과 영롱한 자개 장식, 나전 칠기",""))
        mContentsStoryList.add(ContentsStoryListModels("고종의 국새, 국새 황제지보",""))
        mContentsStoryList.add(ContentsStoryListModels("조선시대 왕들의 글씨를 탁본한, 열성어필",""))

        // 어댑터 연결
        mContentsStoryListAdapter = ContentsStoryListAdapter(this, mContentsStoryList)
        contents_story_list.adapter = mContentsStoryListAdapter

    }
}