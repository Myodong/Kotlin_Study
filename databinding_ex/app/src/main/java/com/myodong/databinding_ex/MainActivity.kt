package com.myodong.databinding_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ActionMenuView
import android.widget.Button
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.myodong.databinding_ex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 바인딩 이용해보기
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // 1번 방식 - 기존 findViewById
        // 프로그래매틱 방식
//        val btn = findViewById<Button>(R.id.testBtnId)
//        btn.setOnClickListener{
//            Toast.makeText(this, "click",Toast.LENGTH_LONG).show()
//        }

        // 2번 방식 - Databinding
        binding.testBtnId.setOnClickListener{
            Toast.makeText(this, "click",Toast.LENGTH_LONG).show()
        }


    }
}