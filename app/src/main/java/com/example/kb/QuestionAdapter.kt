package com.example.kb

import android.content.Context
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.example.kb.Question
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.example.kb.QuestionAdapter.QuestionViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.kb.R
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import androidx.annotation.NonNull

class QuestionAdapter(options: FirestoreRecyclerOptions<Question>)
    : FirestoreRecyclerAdapter<Question,
        QuestionAdapter.QuestionViewHolder>(options) {
    var context: Context? = null

    inner class QuestionAdapter(options: FirestoreRecyclerOptions<Question>, context: QaFragment) {
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int, question: Question ) {
        holder.contentTextView.text = question.content
        holder.timestampTextView.text = question.timestamp.toString()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.qa_list_custom, parent, false)
        return QuestionViewHolder(view)
    }

    class QuestionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var contentTextView: TextView = itemView.findViewById(R.id.qna_editText)
        var timestampTextView: TextView = itemView.findViewById(R.id.qna_day)
    }
}