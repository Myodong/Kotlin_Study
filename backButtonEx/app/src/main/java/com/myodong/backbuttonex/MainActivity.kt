package com.myodong.backbuttonex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    override  fun onBackPressed(){
        // Log로 동작 하는지 확인해 보기
        Log.d("MainActivity","backbutton 작동")
    }

}