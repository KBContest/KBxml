package com.example.kb

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.google.firebase.storage.FirebaseStorage
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class CulturalHeritageAdapter (private val context: Context) : BaseAdapter() {
    var culturalHeritageList = arrayListOf<CulturalHeritage>()

    override fun getCount(): Int {
        return culturalHeritageList.size

    }

    override fun getItem(position: Int): Any {
        return culturalHeritageList[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    fun addItem(fundId: Int, country: String, title: String, targetAmount: Int, currentAmount: Int, endDay:String) {
        var item = CulturalHeritage();

        item.fundId = fundId
        item.country = country
        item.title = title
        item.targetAmount = targetAmount
        item.currentAmount = currentAmount
        item.endDay = endDay

        culturalHeritageList.add(item)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        /* LayoutInflater는 item을 Adapter에서 사용할 View로 부풀려 주는(inflate) 역할을 한다. */
        val view: View = LayoutInflater.from(context).inflate(R.layout.fund_list_custom, null)

        /* 위에서 생성된 view를 item.xml 파일의 각 View와 연결하는 과정이다. */
        val imageView = view.findViewById<ImageView>(R.id.fund_image)
        val country = view.findViewById<TextView>(R.id.fund_country_name)
        val title = view.findViewById<TextView>(R.id.fund_title)
        val percent = view.findViewById<TextView>(R.id.fund_progress_percent)
        val progressBar = view.findViewById<ProgressBar>(R.id.fund_progressBar)
        val targetAmount = view.findViewById<TextView>(R.id.fund_money)
        val fundDay = view.findViewById<TextView>(R.id.fund_day)

        var percentInt: Int
        val dateFormat = SimpleDateFormat("yyyyMMdd")

        /* ArrayList<CulturalHeritage>의 데이터를 TextView와 ProgressBar에 담는다. */
        val culturalHeritage = culturalHeritageList[position]

        // ImageView
        val id = culturalHeritage.fundId
        val storageRef = FirebaseStorage.getInstance().reference.child("test/$id.jpg")
        val localFile = File.createTempFile("tempImage", "jpg")
        storageRef.getFile(localFile).addOnSuccessListener {
            val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
            imageView.setImageBitmap(bitmap)
        }

        country.text = culturalHeritage.country + " 문화재"
        title.text = culturalHeritage.title
        percentInt = (culturalHeritage.currentAmount.toDouble() / culturalHeritage.targetAmount * 100).toInt()
        percent.text = "${percentInt}%"
        progressBar.setProgress(percentInt)
        targetAmount.text = "${culturalHeritage.targetAmount}원"

        var endDay = dateFormat.parse(culturalHeritage.endDay).time
        var today = Calendar.getInstance().apply {
            set(Calendar.HOUR_OF_DAY, 0)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }.time.time
        var dDay = (endDay - today) / (24 * 60 * 60 * 1000)
        if (dDay.toInt() > 0) {
            fundDay.text = "${dDay}일 남음"
        }
        else if (dDay.toInt() == 0) {
            fundDay.text = "오늘 마감"
        }
        else {
            fundDay.text = "모금 종료"
        }

        return view
    }
}