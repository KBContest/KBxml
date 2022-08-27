/*메인 화면_1*/
package com.example.kb

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    lateinit var main_btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)

        /*xml 확인위해 임시 연결(삭제해도 됨)*/
        main_btn = view.findViewById(R.id.main_btn)

        main_btn.setOnClickListener{
            val intent = Intent(context, HomeActivity2::class.java)
            startActivity(intent)
        }
        /*xml 확인위해 임시 연결(삭제해도 됨)*/

        return view
    }
}