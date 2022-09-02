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

class ContentsStoryListActivity : AppCompatActivity(), ListBtnClickListener {

    // 새거
    var adapter: ContentsListBtnAdapter? = null
    var listView: ListView? = null
    var listBtnClickListener: ListBtnClickListener? = null

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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contents_story_list)

        val items= ArrayList<ContentsStoryListModels?>() // new

        val list_adapter = ContentsStoryListAdapter(this,list_array) // 기존
        contents_story_list.adapter = list_adapter // 기존

        adapter = ContentsListBtnAdapter(this, R.layout.contents_list_custom, items, this)

        // 리스트뷰 참조 및 Adapter달기
    }

    // button2가 눌려졌을 때 실행되는 onClick함수
    fun onClick(v: View) {

        // ListBtnClickListener(MainActivity)의 onListBtnClick() 함수 호출
        if (listBtnClickListener != null) {
            listBtnClickListener!!.onListBtnClick(v.tag as Int)
        }
    }

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

    override fun onListBtnClick(position: Int) {
        val intent = Intent(this, ContentsStoryDetailActivity::class.java)
        if(position == 1){
            startActivity(intent)
        }

    }
}