/*회원가입_2*/
package com.example.kb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_sign_up2.*


class SignUpActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)

        val bottomSheetView = layoutInflater.inflate(R.layout.sing_up_bottom_sheet, null)
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(bottomSheetView)

        contents_back_btn2.setOnClickListener(){
            val intent = Intent(this, SignUpActivity1::class.java)
            startActivity(intent)
        }
        next_btn2.setOnClickListener() {
            //bottomSheetDialog.show()
            val intent = Intent(this, SignUpActivity3::class.java)
            val text = editTextTextEmailAddress.text.toString()
            intent.putExtra("email", text)
            startActivity(intent)
        }

    }
}