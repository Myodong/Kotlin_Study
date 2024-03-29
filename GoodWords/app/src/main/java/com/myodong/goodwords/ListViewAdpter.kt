package com.myodong.goodwords

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdpter(val List: MutableList<String>): BaseAdapter() {
    override fun getCount(): Int {
        return List.size
    }

    override fun getItem(position: Int): Any {
        return List[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        var convertView = convertView

        // null 이라면 vlew를 가져와준다
        if(convertView == null){
            convertView = LayoutInflater.from(parent?.context).inflate(R.layout.listview_item, parent, false)
        }

        val listviewText = convertView?.findViewById<TextView>(R.id.listViewTextArea)
        // List에 있는 원소를 넣어준다
        listviewText!!.text = List[position]

        return  convertView!!
    }

}