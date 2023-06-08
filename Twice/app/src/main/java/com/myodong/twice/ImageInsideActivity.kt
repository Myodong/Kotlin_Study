package com.myodong.twice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast

class ImageInsideActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_inside)

        val getDate = intent.getStringExtra("data") // 값 받아오기

//        Toast.makeText(this,getDate,Toast.LENGTH_LONG).show()

        val memberImage = findViewById<ImageView>(R.id.memberImageArea)

        if (getDate=="1"){
            memberImage.setImageResource(R.drawable.member_1)
        }
        if (getDate=="2"){
            memberImage.setImageResource(R.drawable.member_2)
        }
        if (getDate=="3"){
            memberImage.setImageResource(R.drawable.member_3)
        }
        if (getDate=="4"){
            memberImage.setImageResource(R.drawable.member_4)
        }
        if (getDate=="5"){
            memberImage.setImageResource(R.drawable.member_5)
        }
        if (getDate=="6"){
            memberImage.setImageResource(R.drawable.member_6)
        }
        if (getDate=="7"){
            memberImage.setImageResource(R.drawable.member_7)
        }
        if (getDate=="8"){
            memberImage.setImageResource(R.drawable.member_8)
        }
        if (getDate=="9"){
            memberImage.setImageResource(R.drawable.member_9)
        }

    }
}