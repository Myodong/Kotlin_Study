package com.myodong.diet_memo

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.time.Year
import java.util.Calendar
import java.util.GregorianCalendar

class MainActivity : AppCompatActivity() {

    val dataModelList = mutableListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val database = Firebase.database
        val myRef = database.getReference("myMemo")

        // ListView 가져오기
        val listView = findViewById<ListView>(R.id.mainLV)
        // Adapter 가져오기
        val adapter_list = ListViewAdapter(dataModelList)
        //연결하기
        listView.adapter =adapter_list

        myRef.addValueEventListener(object :ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                dataModelList.clear()
                // 반복문을 통해 snapshot에서 데이터 꺼내기
                for(dataModel in snapshot.children){
                    // 리스트에 담기
                    dataModelList.add(dataModel.getValue(DataModel::class.java)!!)

                }
                // 데이터 모델이 다되고 나면 어댑터를 세로 세팅해줘라
                adapter_list.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })

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

            var dateText = ""

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

                        dateText = "${year},${month+1},${dayOfMonth}"
                    }
                }, year, month, date )
                dlg.show()
            }

            // 버튼찾기
            val saveBtn = mAlertDialog.findViewById<Button>(R.id.saveBtn)
            // 버튼클릭시
            saveBtn?.setOnClickListener {

                val healMemo = mAlertDialog.findViewById<EditText>(R.id.healthMemo)?.text.toString()

                val model = DataModel(dateText,healMemo)

                // 데이터가 없으면 넣고 있으면 수정
                //myRef.setValue("Hello, World!")
                //push() 중복 값이 있어도 계속 추가 저장
                //myRef.push().setValue("Hello, World!")
                myRef.push().setValue(model)

                // 저장 클릭 후 다이얼로그 닫기
                mAlertDialog.dismiss()

            }
        }
    }
}