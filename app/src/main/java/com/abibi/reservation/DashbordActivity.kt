package com.abibi.reservation

import adapter.CategoriesAdapter
import adapter.DestinationAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import models.Categories
import models.Destination
import java.security.AccessController.getContext


class DashbordActivity : AppCompatActivity() {

    var recyclerView: RecyclerView? = null
    var categoriesDataSet: ArrayList<Categories>? = null

    var recyclerViewDestination: RecyclerView? = null
    var destinationDataSet: ArrayList<Destination>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashbord)

        recyclerView = findViewById(R.id.categories_recyclerView)
        //recyclerView.hasFixedSize()
        addElementsCategories()

        recyclerViewDestination = findViewById(R.id.destination_recyclerView)
        //recyclerView.hasFixedSize()
        addElementsDestination()


    }

    @SuppressLint("NotifyDataSetChanged")
    fun addElementsCategories() {
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

    @SuppressLint("NotifyDataSetChanged")
    fun addElementsDestination() {
        destinationDataSet = ArrayList()
        (destinationDataSet as ArrayList<Destination>).add(Destination("5.1", "Yaounde", "MbalaII", "$400", "Jour"))
        (destinationDataSet as ArrayList<Destination>).add(Destination("5.1", "Yaounde", "MbalaII", "$400", "Jour"))
        (destinationDataSet as ArrayList<Destination>).add(Destination("5.1", "Yaounde", "MbalaII", "$400", "Jour"))
        (destinationDataSet as ArrayList<Destination>).add(Destination("5.1", "Yaounde", "MbalaII", "$400", "Jour"))
        val adapter = DestinationAdapter(this, destinationDataSet!!)
        recyclerViewDestination!!.adapter = adapter
        recyclerViewDestination!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapter.notifyDataSetChanged()
    }
}