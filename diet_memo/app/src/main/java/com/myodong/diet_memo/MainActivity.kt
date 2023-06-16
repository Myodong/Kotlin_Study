package com.myodong.diet_memo

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.DatePicker
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import java.time.Year
import java.util.Calendar
import java.util.GregorianCalendar

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val writeButton = findViewById<ImageView>(R.id.writeBtn)
        writeButton.setOnClickListener {
        
            // 안드로이드 커스터 다이얼로그 예제 검색해서 참고
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.custom_dialog,null)
            val mBuilder =AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("운동 메모 다이얼로그")

            val mAlertDialog = mBuilder.show()

            // 다이얼로그에서 찾아오기
            val DateSelecBtn = mAlertDialog.findViewById<Button>(R.id.dateSelectBtn)

            // 날짜를 선택해주세요 버튼 클릭 시 이벤트
            DateSelecBtn?.setOnClickListener {

                // 년월일 켈린더 가져오기
                val today = GregorianCalendar()
                val year:Int = today.get(Calendar.YEAR)
                val month:Int = today.get(Calendar.MONTH)
                val date:Int = today.get(Calendar.DATE)

                val dlg = DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener{
                    // 날짜 클릭시 이벤트
                    override fun onDateSet(view: DatePicker?,year: Int,month: Int,dayOfMonth: Int ) {

                        // year.toString() == "${year}"
                        //Log.e("MAIN", year.toString()) ==Log.e("MAIN", "${year}")
                        // 날자 선택시 로그 출력
                        Log.e("MAIN", "${year},${month+1},${dayOfMonth}")
                        DateSelecBtn.setText("${year},${month+1},${dayOfMonth}")
                    }
                }, year, month, date )
                dlg.show()
            }
        }
    }
}