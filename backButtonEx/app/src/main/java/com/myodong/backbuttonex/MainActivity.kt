package com.myodong.backbuttonex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    // 변수 선언
    private  var isDouble = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override  fun onBackPressed(){
        // Log로 동작 하는지 확인해 보기
        Log.d("MainActivity","backbutton 작동")

        isDouble = true
        Toast.makeText(this, "한번더 누르면 종료됩니다.",Toast.LENGTH_SHORT).show()
    }

}