package com.myodong.dday

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import java.util.Calendar
import java.util.GregorianCalendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startBtn)
        val endButton   = findViewById<Button>(R.id.endBtn)

        var startDate=""

        // 시작 버튼 클릭 시
        startButton.setOnClickListener {

            // 다이얼로그 띄우기

            val today = GregorianCalendar()
            val year =  today.get(Calendar.YEAR)
            val month =  today.get(Calendar.MONTH)
            val day =  today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                // 년월일 받아오기
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

                    startDate = "${year}+${month+1}+${dayOfMonth}"
                }

            },year,month,day)

        }
        // 종료 버튼 클릭 시
        endButton.setOnClickListener {

        }


    }
}