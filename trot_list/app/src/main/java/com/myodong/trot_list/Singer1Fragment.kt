package com.myodong.trot_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController


class Singer1Fragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_singer1, container, false)

        // 방법 1
//        view.findViewById<ImageView>(R.id.image1).setOnClickListener{
//
//        }
        // 방법2
//        val image1 = view.findViewById<ImageView>(R.id.image1)
//        image1.setOnClickListener{
//
//        }
        // 이미지 2번 클릭 시
        val image2 = view.findViewById<ImageView>(R.id.image2)
        image2.setOnClickListener{
            // 2번 이미지로 이동
            it.findNavController().navigate(R.id.action_singer1Fragment_to_singer2Fragment)
        }
        // 이미지 3번 클릭 시
        val image3 = view.findViewById<ImageView>(R.id.image3)
        image3.setOnClickListener{
            // 3번 이미지로 이동
            it.findNavController().navigate(R.id.action_singer1Fragment_to_singer3Fragment)
        }

        return view
    }

}