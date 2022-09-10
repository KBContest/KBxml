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

    fun addItem(fundId: Int, country: String, title: String, targetAmount: Int, currentAmount: Int) {
        var item = CulturalHeritage();

        item.fundId = fundId
        item.country = country
        item.title = title
        item.targetAmount = targetAmount
        item.currentAmount = currentAmount

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

        var percentInt: Int

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
        percent.text = "$percentInt%"
        progressBar.setProgress(percentInt)
        targetAmount.text = culturalHeritage.targetAmount.toString()

        return view
    }
}