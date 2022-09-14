/*회원가입_2*/
package com.example.kb

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.activity_sign_up2.*

class SignUpActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)

        val bottomSheetView = layoutInflater.inflate(R.layout.sing_up_bottom_sheet, null)
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(bottomSheetView)

        contents_back_btn2.setOnClickListener {
            val intent = Intent(this, SignUpActivity1::class.java)
            startActivity(intent)
        }
        next_btn2.setOnClickListener{
            val email = editTextTextEmailAddress.getText().toString()
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                editTextTextEmailAddress.error = "Email format is incorrect."
            }
            else {
                val intent = Intent(this, SignUpActivity3::class.java)
                val text = editTextTextEmailAddress.text.toString()
                intent.putExtra("email", text)
                startActivity(intent)
            }

        }
    }

}