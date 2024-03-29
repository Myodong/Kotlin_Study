package com.myodong.trot_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Singer2Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        
        val view = inflater.inflate(R.layout.fragment_singer2, container, false)

        val items = mutableListOf<String>()
        items.add("별빛 같은 나의 사랑아")
        items.add("사랑의 콜센터")
        items.add("영웅시대")
        items.add("이제 나만믿어요")
        items.add("별빛 같은 나의 사랑아")
        items.add("사랑의 콜센터")
        items.add("영웅시대")
        items.add("이제 나만믿어요")
        items.add("별빛 같은 나의 사랑아")
        items.add("사랑의 콜센터")
        items.add("영웅시대")
        items.add("이제 나만믿어요")
        items.add("별빛 같은 나의 사랑아")
        items.add("사랑의 콜센터")
        items.add("영웅시대")
        items.add("이제 나만믿어요")


        val rv =view.findViewById<RecyclerView>(R.id.singRV)
        val rvAdapter = RVAdapter(items)

        rv.adapter =rvAdapter
        rv.layoutManager = LinearLayoutManager(context)

        // 1번 이미지 클릭 시
        val image1 = view.findViewById<ImageView>(R.id.image1)
        image1.setOnClickListener {
            // 1번 이미지로 이동
            it.findNavController().navigate(R.id.action_singer2Fragment_to_singer1Fragment)
        }

        // 다른 방법 사용
        // 3번 이미지 클릭 시
        view.findViewById<ImageView>(R.id.image3).setOnClickListener {
            // 3번 이미지로 이동
            it.findNavController().navigate(R.id.action_singer2Fragment_to_singer3Fragment)
        }

        return view
    }


}