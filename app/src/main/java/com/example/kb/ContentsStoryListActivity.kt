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

    //수정완료
    // push test
    val mContentsStoryList = ArrayList<ContentsStoryListModels>()
    lateinit var mContentsStoryListAdapter: ContentsStoryListAdapter

    // 새거
    //var adapter: ContentsListBtnAdapter? = null
    //var listView: ListView? = null
    //var listBtnClickListener: ListBtnClickListener? = null

    /*
    val list_array = arrayListOf<ContentsStoryListModels>(
        ContentsStoryListModels("망국의 옹주, 덕혜옹주의 스란치마", ""),
        ContentsStoryListModels("다섯개의 산봉우리, 일월오봉도",""),
        ContentsStoryListModels("어보를 품은 상자, 보록", ""),
        ContentsStoryListModels("빼어나게 아름다운 금강산, 금강내산전도", ""),
        ContentsStoryListModels("문신들의 뱃놀이를 그린, 독서당 계회도",""),
        ContentsStoryListModels("검은 옻칠과 영롱한 자개 장식, 나전 칠기", ""),
        ContentsStoryListModels("고종의 국새, 국새 황제지보", ""),
        ContentsStoryListModels("조선시대 왕들의 글씨를 탁본한, 열성어필", "")
    )
    */


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contents_story_list)


        // 수정완료
        setupEvents()
        setValues()


        //val items= ArrayList<ContentsStoryListModels?>() // new

        //val list_adapter = ContentsStoryListAdapter(this,list_array) // 기존
        //contents_story_list.adapter = list_adapter // 기존

        //adapter = ContentsListBtnAdapter(this, R.layout.contents_list_custom, items, this)

        // 리스트뷰 참조 및 Adapter달기
    }

    // button2가 눌려졌을 때 실행되는 onClick함수
    /*
    fun onClick(v: View) {

        // ListBtnClickListener(MainActivity)의 onListBtnClick() 함수 호출
        if (listBtnClickListener != null) {
            listBtnClickListener!!.onListBtnClick(v.tag as Int)
        }
    }

    */


    fun loadItemsFromDB(list: java.util.ArrayList<ContentsStoryListModels?>?): Boolean {
        var list = list
        var item: ContentsStoryListModels
        var i: Int
        if (list == null) {
            list = java.util.ArrayList()
        }

        // 순서를 위한 i 값을 1로 초기화
        i = 1


        // 콘텐츠 리스트 생성
        /*item = ContentsStoryListModels()
        item.title = "첫번째 콘텐츠 이름"
        list.add(item)
        i++

        item = ContentsStoryListModels()
        item.title = "두번째 콘텐츠 이름"
        list.add(item)
        i++

        item = ContentsStoryListModels()
        item.title = "세번째 콘텐츠 이름"
        list.add(item)
        i++

        item = ContentsStoryListModels()
        item.title = "네번째 콘텐츠 이름"
        list.add(item)*/
        return true
    }

    /*
    override fun onListBtnClick(position: Int) {
        val intent = Intent(this, ContentsStoryDetailActivity::class.java)
        if(position == 1){
            startActivity(intent)
        }

    }

     */

    // 수정완료

    fun setupEvents() {

        //메인화면의 이벤트관련 코드를 모아두는 곳
        // 리스트 클릭 이벤트 - 리스트뷰의 각 줄마다 눌렸을때 구동하는 이벤트
        contents_story_list.setOnItemClickListener { adapterView, view, i, l ->

            // 눌린 위치에 해당하는 목록이 어떤 목록인지 가져오기
            val clickedList = mContentsStoryList[i]
            // 선택된 목록정보를 가져왔으면 이제 화면 이동
            val myIntent = Intent(this, ContentsListCustomActivity::class.java)
            // 정보를 담아주기
            // 화면 전환
            if(i==0){
                startActivity(Intent(this@ContentsStoryListActivity, ContentsStoryDetailActivity::class.java))
            }
        }
    }

    fun setValues() {
        mContentsStoryList.add(ContentsStoryListModels("망국의 옹주, 덕혜옹주의 스란치마",""))
        mContentsStoryList.add(ContentsStoryListModels("다섯개의 산봉우리, 일월오봉도",""))
        mContentsStoryList.add(ContentsStoryListModels("어보를 품은 상자, 보록",""))
        mContentsStoryList.add(ContentsStoryListModels("빼어나게 아름다운 금강산, 금강내산전도",""))
        mContentsStoryList.add(ContentsStoryListModels("문신들의 뱃놀이를 그린, 독서당 계회도",""))
        mContentsStoryList.add(ContentsStoryListModels("검은 옻칠과 영롱한 자개 장식, 나전 칠기",""))
        mContentsStoryList.add(ContentsStoryListModels("고종의 국새, 국새 황제지보",""))
        mContentsStoryList.add(ContentsStoryListModels("조선시대 왕들의 글씨를 탁본한, 열성어필",""))

        mContentsStoryListAdapter = ContentsStoryListAdapter(this, mContentsStoryList)
        contents_story_list.adapter = mContentsStoryListAdapter

    }
}