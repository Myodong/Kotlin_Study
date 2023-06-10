package com.myodong.nav_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class FirstFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_first, container, false)

        // 버튼2 클릭 시
        view.findViewById<Button>(R.id.btn2).setOnClickListener{
            // firstFragment 에서 secondFragment로 이동한다.
            it.findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        // 버튼3 클릭 시
        view.findViewById<Button>(R.id.btn3).setOnClickListener{
            // firstFragment 에서 thirdFragment로 이동한다.
            it.findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }


        return view
    }


}