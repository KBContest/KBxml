/*마이페이지_1*/
package com.example.kb

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class MypageFragment : Fragment() {

    lateinit var wrote_btn:Button
    lateinit var fund_btn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_mypage, container, false)


        /*xml 확인위해 임시 연결(삭제해도 됨)*/
        wrote_btn = view.findViewById(R.id.wrote_btn)
        fund_btn = view.findViewById(R.id.fund_btn)

        wrote_btn.setOnClickListener{
            val intent = Intent(context, MypageWroteActivity::class.java)
            startActivity(intent)
        }
        fund_btn.setOnClickListener{
            val intent = Intent(context, MypageFundActivity::class.java)
            startActivity(intent)
        }
        /*xml 확인위해 임시 연결(삭제해도 됨)*/

        return view
    }

}