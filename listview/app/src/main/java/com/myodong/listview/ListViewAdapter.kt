package com.myodong.listview

import android.view.LayoutInflater
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

    // List에 있는 item 애들을 하나씩 넣어줌
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        //  listview_item.xml 에서 만들어진 item을 Adapter에 연결하기
        var convertView = convertView

        if(convertView == null){
            // listview_item.xml item에 있는 뷰를 가져오는 코드
            convertView = LayoutInflater.from(parent?.context).inflate(R.layout.listview_item,parent,false)
        }

        return  convertView!!
    }
}