package com.myodong.mango_contents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private  val items = mutableListOf<ContentModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 북마크 클릭시 설정
        val bookmarkButton = findViewById<TextView>(R.id.bookmarkBtn)
        bookmarkButton.setOnClickListener {

            val intent = Intent(this, BookmarkActivity::class.java)
            startActivity(intent)
        }

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
                "https://www.mangoplate.com/restaurants/zqa4ktmPw3hA",
                "https://mp-seoul-image-production-s3.mangoplate.com/467077_1587660803317727.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "엘리스리틀이태리"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/KoWdFMdQ5L8L",
                "https://mp-seoul-image-production-s3.mangoplate.com/47875_1629891127614151.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "카와카츠"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/ogLsfHRX4bR1",
                "https://mp-seoul-image-production-s3.mangoplate.com/1433827_1627493891796261.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "우주옥"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/MMEELt3usvci",
                "https://mp-seoul-image-production-s3.mangoplate.com/817437_1610944024756964.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "라바즈"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/DB-nxyYhQbEJ",
                "https://mp-seoul-image-production-s3.mangoplate.com/707184_1613622336201662.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "파이리퍼블릭"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/IpF3Adr6JcG3",
                "https://mp-seoul-image-production-s3.mangoplate.com/32408_1687250853381799.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "숙성육관"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/b_gNU4tCqinD",
                "https://mp-seoul-image-production-s3.mangoplate.com/333716/90579_1507892049345_90579_1507890659162_180366?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "멜드 바이 기치조지"
            )
        )
        items.add(
            ContentModel(
                "https://www.mangoplate.com/restaurants/0my2hMzHlOYD",
                "https://mp-seoul-image-production-s3.mangoplate.com/added_restaurants/35813_1490342731688208.jpg?fit=around|512:512&crop=512:512;*,*&output-format=jpg&output-quality=80",
                "당도"
            )
        )

        // 리사이클러뷰 연결
        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(baseContext,items)
        recyclerview.adapter = rvAdapter

        rvAdapter.itemClick = object :RVAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {

                // ViewActivity 뷰화면으로 넘겨주기
                val intent = Intent(baseContext, ViewActivity::class.java)
                intent.putExtra("url",items[position].url)
                intent.putExtra("title",items[position].titleText)
                intent.putExtra("imageUrl",items[position].imageUrl)
                startActivity(intent)
            }

        }

        // 화면 리스트 한줄 출력
        //recyclerview.layoutManager = LinearLayoutManager(this)
        // 화면 리스트 두줄 출력
        recyclerview.layoutManager = GridLayoutManager(this,2)
    }
}