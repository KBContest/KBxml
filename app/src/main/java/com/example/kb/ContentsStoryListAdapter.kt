package com.example.kb

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ContentsStoryListAdapter(val context: Context, val list:ArrayList<ContentsStoryListModels>):BaseAdapter() {
    // push test
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view : View
        val holder : ViewHolder

        if (convertView == null){
            view = LayoutInflater.from(context).inflate(R.layout.contents_list_custom, null)

            holder = ViewHolder()

            holder.text = view.findViewById(R.id.item_title)
            holder.image = view.findViewById(R.id.detail_btn)

            view.tag = holder
        }
        else{
            holder = convertView.tag as ViewHolder
            view = convertView
        }

        val item = list[position]

        holder.text?.text = item.title


        return view


    }

    override fun getItem(p0: Int): Any {
        return list.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return list.size
    }

    private class ViewHolder{
        var text: TextView?= null
        var image: ImageView?= null

    }
}