package com.example.kb

import android.app.Activity;
import android.content.Context;
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*
import java.util.ArrayList



class ContentsListBtnAdapter internal constructor(
    context: Context?,
    var resourceId: Int, list: ArrayList<ContentsStoryListModels?>?,
    private val listBtnClickListener: ListBtnClickListener?
) : ArrayAdapter<Any?>(
    context!!, resourceId, list!! as List<Any?>
), View.OnClickListener {
    interface ListBtnClickListener {
        fun onListBtnClick(position: Int)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val context = parent.context

        if (convertView == null) {
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            convertView = inflater.inflate(resourceId /*R.layout.listview_btn_item*/, parent, false)
        }

        val listViewItem = getItem(position) as ContentsStoryListModels?

        val button2 = convertView?.findViewById<View>(R.id.detail_btn) as ImageButton
        button2.tag = position
        button2.setOnClickListener(this)
        return convertView
    }

    // button2가 눌려졌을 때 실행되는 onClick함수
    override fun onClick(v: View) {
        if (listBtnClickListener != null) {
            listBtnClickListener.onListBtnClick(v.tag as Int)
        }
    }

}