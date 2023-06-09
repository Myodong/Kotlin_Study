package com.myodong.backbuttonex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    // 변수 선언
    private  var isDouble = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override fun onBackPressed() {

        // Log로 동작 하는지 확인해 보기
        Log.d("MainActivity", "backbutton 작동")

        // 두번 클릭 시 종료 시켜라 
        if(isDouble == true){
            finish()
        }

        isDouble = true
        // 메세지 출력
        Toast.makeText(this, "한번더 누르면 종료됩니다.", Toast.LENGTH_SHORT).show()

        // 2초뒤 다시 변수 변경
        Handler().postDelayed(Runnable {
            isDouble=false
        },2000)
    }
}