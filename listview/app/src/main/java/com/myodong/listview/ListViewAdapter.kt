package com.myodong.listview

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

class ListViewAdapter(val List : MutableList<String>) : BaseAdapter(){

    // ListView의 item들의 갯수
    override fun getCount(): Int {
        // item들의 갯수는 List의 사이즈 만큼만 하겠다
        return List.size
    }

    // 아직 크게 신경 안써도 된다
    override fun getItem(position: Int): Any {
        // List의 item을 가져다 주고
        return List[position]
    }
    // 아직 크게 신경 안써도 된다
    override fun getItemId(position: Int): Long {
        
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        TODO("Not yet implemented")
    }
}