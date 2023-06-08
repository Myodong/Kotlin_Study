package com.myodong.bts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. 화면이 클릭되었다는 것을 알아야 합니다. (프로그램이)
        val image1 = findViewById<ImageView>(R.id.bts_image_1) // actitvity_main.xml에서 가져온다
        val image2 = findViewById<ImageView>(R.id.bts_image_2)
        val image3 = findViewById<ImageView>(R.id.bts_image_3)
        val image4 = findViewById<ImageView>(R.id.bts_image_4)
        val image5 = findViewById<ImageView>(R.id.bts_image_5)
        val image6 = findViewById<ImageView>(R.id.bts_image_6)
        val image7 = findViewById<ImageView>(R.id.bts_image_7)

        // image1 클릭 이벤트
        image1.setOnClickListener {
            // 메세지 출력
            Toast.makeText(this, "1번 클릭 완료",Toast.LENGTH_LONG).show()

            // 2. 화면이 클릭되면, 다음 화면으로 넘어가서, 사진을 크게 보여줌
            val intentBts1 = Intent(this, Bts1Activity::class.java)
            startActivity(intentBts1)
        }

        image2.setOnClickListener {
            val intentBts2 = Intent(this, Bts2Activity::class.java)
            startActivity(intentBts2)
        }

        image3.setOnClickListener {
            val intentBts3 = Intent(this, Bts3Activity::class.java)
            startActivity(intentBts3)
        }

        image4.setOnClickListener {
            val intentBts4 = Intent(this, Bts4Activity::class.java)
            startActivity(intentBts4)
        }

        image5.setOnClickListener {
            val intentBts5 = Intent(this, Bts5Activity::class.java)
            startActivity(intentBts5)
        }

        image6.setOnClickListener {
            val intentBts6 = Intent(this, Bts6Activity::class.java)
            startActivity(intentBts6)
        }

        image7.setOnClickListener {
            val intentBts7 = Intent(this, Bts7Activity::class.java)
            startActivity(intentBts7)
        }





    }
}