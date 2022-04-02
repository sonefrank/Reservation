package com.abibi.reservation

import adapter.CategoriesAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import models.Categories
import java.security.AccessController.getContext


class DashbordActivity : AppCompatActivity() {

    var recyclerView: RecyclerView? = null
    var categoriesDataSet: ArrayList<Categories>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashbord)

        recyclerView = findViewById(R.id.categories_recyclerView)
        //recyclerView.hasFixedSize()
        addElements()

    }

    @SuppressLint("NotifyDataSetChanged")
    fun addElements() {
        categoriesDataSet = ArrayList()
        (categoriesDataSet as ArrayList<Categories>).add(Categories("Bafoussam", R.drawable.icons8_mountain_47))
        (categoriesDataSet as ArrayList<Categories>).add(Categories("Bafoussam", R.drawable.icons8_mountain_47))
        (categoriesDataSet as ArrayList<Categories>).add(Categories("Bafoussam", R.drawable.icons8_mountain_47))
        (categoriesDataSet as ArrayList<Categories>).add(Categories("Bafoussam",  R.drawable.icons8_mountain_47))
        val adapter = CategoriesAdapter(this, categoriesDataSet!!)
        recyclerView!!.adapter = adapter
        recyclerView!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapter.notifyDataSetChanged()
    }
}