package com.myodong.fb_login_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        findViewById<Button>(R.id.noEmailLoginBtn).setOnClickListener{

            auth.signInAnonymously().addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) { // 로그인 성공시

                        val user = auth.currentUser

                        // uid 값을 가져온다
                        Log.d("MainActivity",user!!.uid)

                    } else {
                        // If sign in fails, display a message to the user.

                        Toast.makeText(baseContext,"Authentication failed.",Toast.LENGTH_SHORT,).show()
                    }
                }
        }

    }
}