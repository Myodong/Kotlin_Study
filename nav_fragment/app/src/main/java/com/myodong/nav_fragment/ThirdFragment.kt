package com.myodong.nav_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController

class ThirdFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view = inflater.inflate(R.layout.fragment_third, container, false)

        // 버튼1 클릭 시
        view.findViewById<Button>(R.id.btn1).setOnClickListener{
            // thirdFragment로 에서 firstFragment 이동한다.
            it.findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
        }

        // 버튼2 클릭 시
        view.findViewById<Button>(R.id.btn3).setOnClickListener{
            // thirdFragment로 에서 secondFragment 이동한다.
            it.findNavController().navigate(R.id.action_thirdFragment_to_secondFragment)
        }

        return view
    }

}