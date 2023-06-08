package com.myodong.list_ex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var testList = mutableListOf<String>()
        testList.add("a")
        testList.add("b")
        testList.add("c")
    }
}