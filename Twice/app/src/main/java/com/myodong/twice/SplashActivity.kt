package com.myodong.twice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

@Suppress("DEPRECATION") // Handler() 가로줄 문제 해결
class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // 3초뒤에 MainActivity로 넘어간다.
        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        },3000) // 3000 = 3초

    }
}