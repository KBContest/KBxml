/*회원가입_1*/
package com.example.kb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.ContextCompat.startActivity
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.Auth.GoogleSignInApi
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.rpc.context.AttributeContext
import kotlinx.android.synthetic.main.activity_sign_up1.*

@Suppress("DEPRECATION")
class SignUpActivity1 : AppCompatActivity() {

    lateinit var signupBtn: Button
    lateinit var googleBtn: Button
    var googleSignInClient: GoogleSignInClient? = null
    var auth: FirebaseAuth? = null
    var GOOGLE_LOGIN_CODE = 9001
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up1)

        var signupBtn: Button = findViewById(R.id.sign_up_btn)
        var googleBtn: Button = findViewById(R.id.google_login_btn)

        signupBtn.setOnClickListener {
            startActivity(Intent(this, SignUpActivity2::class.java))
            finish()
        }

        google_login_btn.setOnClickListener {
            //First step
            googleLogin()
        }
        var gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("367622756287-pfs7amud4qrn0n34kd6hj4dhvr8dk3lg.apps.googleusercontent.com")
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, gso)
    }

    @Suppress("DEPRECATION")
    fun googleLogin(){
        var signInIntent= googleSignInClient?.signInIntent
        startActivityForResult(signInIntent, GOOGLE_LOGIN_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == GOOGLE_LOGIN_CODE){
            var result = Auth.GoogleSignInApi.getSignInResultFromIntent(data!!)
            if(result!!.isSuccess){
                var account = result.signInAccount
                //Second step
                firebaseAuthWithGoogle(account)
            }
        }
    }
    fun firebaseAuthWithGoogle(account : GoogleSignInAccount?){
        var credential = GoogleAuthProvider.getCredential(account?.idToken, null)
        auth?.signInWithCredential(credential)
            ?.addOnCompleteListener {
                    task ->
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
    }
}