package com.myodong.listview_second_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ListViewAdapter(val List : MutableList<ListViewModel>) : BaseAdapter() {
//class ListViewAdapter(val List : MutableList<String>) : BaseAdapter() {
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

        // List = [
        // ListViewModel("a","b"),
        // ListViewModel("a","b"),
        // ListViewModel("a","b")
        // ]

        if (convertView==null){
            convertView = LayoutInflater.from(parent?.context).inflate(R.layout.listview_item,parent,false)
        }

        val title = convertView!!.findViewById<TextView>(R.id.listviewItemText)
        val title2 = convertView!!.findViewById<TextView>(R.id.listviewItemText2)
//        title.text = List[position]
        title.text = List[position].text1
        title2.text = List[position].text2


        return convertView!!
    }

}