package com.myodong.mango_contents

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class RVAdapter(val context : Context, val List : MutableList<ContentModel>) : RecyclerView.Adapter<RVAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rv_item,parent,false)
        return ViewHolder(v)
    }

    interface ItemClick {
        fun onClick(view : View, position: Int)
    }
    var itemClick : ItemClick? = null

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {

        if (itemClick != null){
            holder?.itemView?.setOnClickListener{ v->
                itemClick!!.onClick(v,position)
            }
        }
        holder.bindItems(List[position])
    }

    override fun getItemCount(): Int {
        return  List.size
    }
    //ViewHolder 만들기
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        //바인딩
        fun bindItems(item : ContentModel){
            val rv_text  = itemView.findViewById<TextView>(R.id.rvTextArea)
            val rv_img = itemView.findViewById<ImageView>(R.id.rvImageArea)

            rv_text.text = item.titleText
            // glide 이용
            Glide.with(context).load(item.imageUrl).into(rv_img)
        }
    }
}