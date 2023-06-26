package com.myodong.dday

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import java.util.Calendar
import java.util.GregorianCalendar
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton = findViewById<Button>(R.id.startBtn)
        val endButton   = findViewById<Button>(R.id.endBtn)

        var startDate=""
        var endDate=""

        val calendar_start=Calendar.getInstance()
        val calendar_end=Calendar.getInstance()

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

                    // 아래 둘다 같은 코드
                    //startDate= year.toString() + (month+1).toString()+dayOfMonth.toString()
                    startDate = "${year}"+"${month+1}"+"${dayOfMonth}"

                    calendar_start.set(year,month+1,dayOfMonth)

                    Log.e("day: ",startDate )
                }

            },year,month,day)
            dlg.show()
        }
        // 종료 버튼 클릭 시
        endButton.setOnClickListener {

            // 다이얼로그 띄우기
            val today = GregorianCalendar()
            val year =  today.get(Calendar.YEAR)
            val month =  today.get(Calendar.MONTH)
            val day =  today.get(Calendar.DATE)

            val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                // 년월일 받아오기
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

                    // 아래 둘다 같은 코드
                    //endDate= year.toString() + (month+1).toString()+dayOfMonth.toString()
                    endDate = "${year}"+"${month+1}"+"${dayOfMonth}"
                    Log.e("day: ",endDate )

                    calendar_end.set(year,month+1,dayOfMonth)
                    // 시간계산
                    val finalDate = TimeUnit.MILLISECONDS.toDays(calendar_end.timeInMillis-calendar_start.timeInMillis)

                    val textArea =  findViewById<TextView>(R.id.finalDate)
                    // 문자열을 숫자로 만들어 toInt() 연산후 다시 문자열로 setText에 넣어줌
                    //textArea.setText((endDate.toInt() - startDate.toInt()+1).toString())

                    textArea.setText(finalDate.toString())


                }

            },year,month,day)
            dlg.show()
        }


    }
}