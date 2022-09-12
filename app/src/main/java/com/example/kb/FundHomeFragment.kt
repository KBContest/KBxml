/*모금 홈*/
package com.example.kb

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
//import kotlinx.android.synthetic.main.activity_contents_story_list.*


class FundHomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fund_home, container, false)

        // 수정완료
        setupEvents()
        setValues()
    }

    fun setupEvents() {

        //메인화면의 이벤트관련 코드를 모아두는 장소
        // 리스트 클릭 이벤트 - 리스트뷰의 각 줄이 눌리는 시점의 이벤트

        contents_story_list.setOnItemClickListener { adapterView, view, i, l ->

            // 눌린 위치에 해당하는 목록이 어떤 목록인지 가져오기
            val clickedList = mContentsStoryList[i]
            // 선택된 목록정보를 가져왔으면 이제 화면 이동
            val myIntent = Intent(this, ContentsListCustomActivity::class.java)
            // 정보를 담아주기
            // 2번에서는 해당 부분 오류남. 3번하고 난 다음 여기로 다시 와야함
            //myIntent.putExtra("roomInfo", clickedList)
            // 화면 전환
            if(i==0){
                startActivity(Intent(this@ContentsStoryListActivity, ContentsStoryDetailActivity::class.java))
            }
        }
    }

    fun setValues() {


        //mContentsStoryList.add(ContentsStoryListModels("망국의 옹주, 덕혜옹주의 스란치마",""))
        //mContentsStoryList.add(ContentsStoryListModels("다섯개의 산봉우리, 일월오봉도",""))
        //mContentsStoryList.add(ContentsStoryListModels("어보를 품은 상자, 보록",""))
        //mContentsStoryList.add(ContentsStoryListModels("빼어나게 아름다운 금강산, 금강내산전도",""))
        //mContentsStoryList.add(ContentsStoryListModels("문신들의 뱃놀이를 그린, 독서당 계회도",""))
        //mContentsStoryList.add(ContentsStoryListModels("검은 옻칠과 영롱한 자개 장식, 나전 칠기",""))
        //mContentsStoryList.add(ContentsStoryListModels("고종의 국새, 국새 황제지보",""))
        //mContentsStoryList.add(ContentsStoryListModels("조선시대 왕들의 글씨를 탁본한, 열성어필",""))

        mContentsStoryListAdapter = ContentsStoryListAdapter(this, mContentsStoryList)
        contents_story_list.adapter = mContentsStoryListAdapter

    }

}