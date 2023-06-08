package com.myodong.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ListViewModel를 넣겠다
        val list_item = mutableListOf<ListViewModel>()

        list_item.add(ListViewModel("a","b"))
        list_item.add(ListViewModel("c","d"))
        list_item.add(ListViewModel("e","f"))

        // 데이터 만들기
        //val list_item = mutableListOf<String>()

       // list_item.add("A")
       // list_item.add("B")
       // list_item.add("C")

        val listview = findViewById<ListView>(R.id.mainListview)

        //  어뎁터에 데이터 넘겨주기
        val listAdapter = ListViewAdapter(list_item)

        // 리스튜뷰에 있는 어뎁터에 listAdapter를 연결한다
        listview.adapter = listAdapter
    }
}