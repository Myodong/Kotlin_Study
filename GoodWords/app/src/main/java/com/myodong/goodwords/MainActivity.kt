package com.myodong.goodwords

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.myodong.goodwords.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private  lateinit var binding : ActivityMainBinding
    // 뒤로가기 종료 변수
    private var isDouble = false

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 문자열 List 선언
        val sentenceList = mutableListOf<String>()
        sentenceList.add("검정화면에 대충 흰글씨 쓰면 명언 같다.")
        sentenceList.add("삶이 있는 한 희망은 있다 -키케로")
        sentenceList.add("산다는것 그것은 치열한 전투이다. -로망로랑")
        sentenceList.add("하루에 3시간을 걸으면 7년 후에 지구를 한바퀴 돌 수 있다. -사무엘존슨")
        sentenceList.add("언제나 현재에 집중할수 있다면 행복할것이다. -파울로 코엘료")
        sentenceList.add("진정으로 웃으려면 고통을 참아야하며 , 나아가 고통을 즐길 줄 알아야 해 -찰리 채플린")
        sentenceList.add("직업에서 행복을 찾아라. 아니면 행복이 무엇인지 절대 모를 것이다 -엘버트 허버드")
        sentenceList.add("신은 용기있는자를 결코 버리지 않는다 -켄러")

        // List 에 있는 원소가 random으로 나오는지 확인하기
        Log.e("MainActivity",sentenceList.random())

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        // 바인딩에서 showAllSentenceBtn 클릭하면 어떻게 해줄꺼냐?
        binding.showAllSentenceBtn.setOnClickListener{

            // 버튼 클릭 시 다음화면으로 넘어가서, 명언을 크게 보여줌
            val intent = Intent(this,SentenceActivity::class.java)
            startActivity(intent)
        }
        
        // List에서 원소를 random으로 화면에 보여주기
        binding.goodWordTextArea.setText(sentenceList.random())
    }

    override fun onBackPressed() {

        if (isDouble==true){
            finish()
        }

        Toast.makeText(this, "한번더 누르면 종료됩니다.",Toast.LENGTH_LONG).show()
        // 변수값 변경
        isDouble = true

        Handler().postDelayed(Runnable {
            isDouble = false
        },2000)
    }
}