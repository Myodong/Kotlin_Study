package com.myodong.mango_contents

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private  val items = mutableListOf<ContentModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/XRoMziImmYCC",
            "https://mp-seoul-image-production-s3.mangoplate.com/2252480_1673490011938600.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
            "뉴욕택시디저트"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/bKBEWmF8MVGb",
                "https://mp-seoul-image-production-s3.mangoplate.com/356501/142542_1674390154744_1000001530?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "동경산책"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/pVydRWGId3d8",
                "https://mp-seoul-image-production-s3.mangoplate.com/sources/web/restaurants/398605/1062290_1606269461021?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "피자보이시나"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/mmhYgR5FVnYH",
                "https://mp-seoul-image-production-s3.mangoplate.com/516849_1579437536418491.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "경원치킨"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/XRoMziImmYCC",
                "https://mp-seoul-image-production-s3.mangoplate.com/2252480_1673490011938600.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "뉴욕택시디저트"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/bKBEWmF8MVGb",
                "https://mp-seoul-image-production-s3.mangoplate.com/356501/142542_1674390154744_1000001530?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "동경산책"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/pVydRWGId3d8",
                "https://mp-seoul-image-production-s3.mangoplate.com/sources/web/restaurants/398605/1062290_1606269461021?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "피자보이시나"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/mmhYgR5FVnYH",
                "https://mp-seoul-image-production-s3.mangoplate.com/516849_1579437536418491.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "경원치킨"
            )
        )

        // 리사이클러뷰 연결
        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext,items)
        recyclerview.adapter = rvAdapter

        rvAdapter.itemClick = object :RVAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {

            }

        }

        // 화면 리스트 한줄 출력
        //recyclerview.layoutManager = LinearLayoutManager(this)
        // 화면 리스트 두줄 출력
        recyclerview.layoutManager = GridLayoutManager(this,2)
    }
}