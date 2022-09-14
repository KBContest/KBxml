/*질의응답_1*/
package com.example.kb

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_qa.*

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class QaFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_qa, container, false)
        val qnaBtn = view.findViewById<Button>(R.id.qna_btn)
        val qnaEditText = view.findViewById<EditText>(R.id.qna_editText1)

        val database = FirebaseDatabase.getInstance()
        // val myRef = database.getReference("question")
        val myRef = database.getReference("/information/question")

        qnaBtn.setOnClickListener {
            myRef.setValue(qna_editText1.text.toString())
            val intent = Intent(activity, QaActivity2::class.java)
            //          intent.putExtra("question", qna_editText.text.toString())
            startActivity(intent)

        }
        qnaEditText.addTextChangedListener(object: TextWatcher {

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                qna_text_count.text = "0 / 150"
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                var userinput =  qna_editText1.text.toString()
                qna_text_count.text = userinput.length.toString() + " / 150"
            }

            override fun afterTextChanged(s: Editable?) {
                var userinput = qna_editText1.text.toString()
                qna_text_count.text = userinput.length.toString() + " / 150"
            }

        })

        return view
    }
}