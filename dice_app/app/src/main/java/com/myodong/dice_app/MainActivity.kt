package com.myodong.dice_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.myodong.dice_app.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        // id 값을 이용하여 찾아온 ImageView 변수에 넣기
        val diceImage1 = binding.dice1
        val diceImage2 = binding.dice2

        binding.diceStartBtn.setOnClickListener{

            // Toast메시지로 확인해보기
            Toast.makeText(this,"주사위가 돌아갑니다. ",Toast.LENGTH_SHORT).show()

            // 테스트 로그 d(디버그) 확인
//            Log.d("MainActivity",Random.nextInt(1,6).toString())
//            Log.d("MainActivity",Random.nextInt(1,6).toString())

            // Random 내장 함수
//            Random.nextInt(1,6)
//            Random.nextInt(1,6)

            // 변수에 랜덤값 담기
            val number1 = Random.nextInt(1,6)
            val number2 = Random.nextInt(1,6)

            // number 1 에 대한 if 문
            if (number1 == 1){
                // 버튼 클릭 시 이미지 변경
                diceImage1.setImageResource(R.drawable.dice_1)
                Log.d("MainActivity",number1.toString())
            } else if(number1 == 2 ){
                diceImage1.setImageResource(R.drawable.dice_2)
                Log.d("MainActivity",number1.toString())

            }else if(number1 == 3 ){
                diceImage1.setImageResource(R.drawable.dice_3)
                Log.d("MainActivity",number1.toString())

            }else if(number1 == 4 ){
                diceImage1.setImageResource(R.drawable.dice_4)
                Log.d("MainActivity",number1.toString())

            }else if(number1 == 5 ){
                diceImage1.setImageResource(R.drawable.dice_5)
                Log.d("MainActivity",number1.toString())

            }else{
                diceImage1.setImageResource(R.drawable.dice_6)
                Log.d("MainActivity",number1.toString())

            }

            // number 2 에 대한 if 문
            if (number2 == 1){
                // 버튼 클릭 시 이미지 변경
                diceImage2.setImageResource(R.drawable.dice_1)
                Log.d("MainActivity",number2.toString())
            } else if(number2 == 2 ){
                diceImage2.setImageResource(R.drawable.dice_2)
                Log.d("MainActivity",number2.toString())
            }else if(number2 == 3 ){
                diceImage2.setImageResource(R.drawable.dice_3)
                Log.d("MainActivity",number2.toString())
            }else if(number2 == 4 ){
                diceImage2.setImageResource(R.drawable.dice_4)
                Log.d("MainActivity",number2.toString())
            }else if(number2 == 5 ){
                diceImage2.setImageResource(R.drawable.dice_5)
                Log.d("MainActivity",number2.toString())
            }else{
                diceImage2.setImageResource(R.drawable.dice_6)
                Log.d("MainActivity",number2.toString())
            }


        }
    }
}