package com.myodong.rv_ex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(val items : MutableList<String>) :RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    // RecyclerView item을 가져온다
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)

        return ViewHolder(view)
    }

    // setOnItemClickListener이 RecyclerView에는 없음
    // 직접 선언해 주기
    interface ItemClick{
        fun onClick(view: View, position: Int)
    }
    var itemClick: ItemClick? = null


    // ViewHolder에 Binding
    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {

        // 클릭이벤트를 위해 추가
        if(itemClick !=null){
            holder.itemView.setOnClickListener{v ->
                itemClick?.onClick(v, position)
            }
        }

        holder.bindItems(items[position])
    }

    // RecyclerView의 전체 카운드 갯수
    // 전체 리사이클러뷰의 갯수
    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(item : String){

            val rv_text = itemView.findViewById<TextView>(R.id.rvItem)
            rv_text.text=item


        }
    }
}