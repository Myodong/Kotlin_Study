package com.myodong.rv_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(val items : MutableList<String>) :RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    // RecyclerView item을 가져온다
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)

        return ViewHolder(view)
    }

    // ViewHolder에 Binding
    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        holder.bindItems(items[position])
    }

    // RecyclerView의 전체 카운드 갯수
    // 전체 리사이클러뷰의 갯수
    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(item : String){

        }
    }
}