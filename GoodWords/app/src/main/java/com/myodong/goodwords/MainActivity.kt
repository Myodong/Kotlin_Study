package com.myodong.goodwords

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.myodong.goodwords.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private  lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // 바인딩에서 showAllSentenceBtn 클릭하면 어떻게 해줄꺼냐?
        binding.showAllSentenceBtn.setOnClickListener{

            // 버튼 클릭 시 다음화면으로 넘어가서, 명언을 크게 보여줌
            val intent = Intent(this,SentenceActivity::class.java)
            startActivity(intent)

        }
    }
}