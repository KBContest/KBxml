package com.example.kb

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentReference
import kotlinx.android.synthetic.main.activity_qa2.*
import kotlinx.android.synthetic.main.fragment_qa.*

class QuestionDetailsActivity : AppCompatActivity() {
    // var contentEditText: EditText? = null
    // var saveQuestionBtn: Button? = null
    // val inflater :Inflater? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_qa)

        println("이동했습니다.")
        val saveQuestionBtn : Button? = findViewById(R.id.qna_btn)
        saveQuestionBtn!!.setOnClickListener { saveNote() }
    }

    private fun saveNote() {
        //val contentEditText : EditText?= findViewById(R.id.qna_editText)
        println("완료")
        val question = Question()
        question.content = qna_editText.text.toString()
        //question.timestamp = System.currentTimeMillis()
        saveNoteToFirebase(question)
    }
    private fun saveNoteToFirebase(question: Question) {

        val documentReference: DocumentReference = Utility().getCollectionReferenceForNotes().document("my question")
        println("성공/실패1")
        documentReference.set(question).addOnCompleteListener{
            println("성공/실패")
            finish()
        }
    }
}