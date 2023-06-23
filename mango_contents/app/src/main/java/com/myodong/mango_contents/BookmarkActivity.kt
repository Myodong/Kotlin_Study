package com.myodong.mango_contents

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class BookmarkActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val contentModels = mutableListOf<ContentModel>()

    override fun onCreate(savedInstanceState: Bundle?) {

        auth = Firebase.auth

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookmark)

        val recyclerview = findViewById<RecyclerView>(R.id.rv)
        val rvAdapter = RVAdapter(this,contentModels)
        recyclerview.adapter = rvAdapter
        recyclerview.layoutManager = GridLayoutManager(this,2)

        val database = Firebase.database
        //저장 경로
        val myBookMarkRef = database.getReference("bookmark_ref")

        myBookMarkRef
            .child(auth.currentUser?.uid.toString())
            .addValueEventListener(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {

                    for (dataModel in snapshot.children){

                        Log.e("Datamodel",dataModel.toString())
                        contentModels.add(dataModel.getValue(ContentModel::class.java)!!)
                    }
                    // 데이터 동기화
                    rvAdapter.notifyDataSetChanged()
                }

                // 실패할경우
                override fun onCancelled(error: DatabaseError) {
                    Log.e("Bookmark","DB_Error")
                }
            })
    }
}