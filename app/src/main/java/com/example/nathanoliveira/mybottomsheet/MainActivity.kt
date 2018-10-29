package com.example.nathanoliveira.mybottomsheet

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.setContentView


class MainActivity : AppCompatActivity() {

    lateinit var ui: MainActivityUi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        imageViewArrow.setOnClickListener { _ -> bottomSheetLayout.toggle() }
//        bottomSheetLayout.setOnProgressListener { progress -> rotateArrow(progress)}



        ui = MainActivityUi()

        ui.setContentView(this)
        val cards = ArrayList<String>()

        for (i in 1..20) {
            cards.add("test")
        }


        ui.rvList2.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                Log.d("rabana",dx.toString()+ dy)
//                if (dy > 0) {
//                    // Scrolling up
//
//                    ui.bottomSheetLayout.scrollable = null
//                } else {
//                    // Scrolling down
//
//                ui.bottomSheetLayout.scrollable = recyclerView
//                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView?, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                Log.d("rabana",newState.toString()+"nathan")
                if (newState == 0 ){
                    ui.bottomSheetLayout.scrollable =   ui.rvList
                }else{

                }

            }
        })
        ui.rvList.onClick {
            ui.bottomSheetLayout.scrollable =   ui.rvList
        }


        ui.rvList.adapter = MenuAdapter(this@MainActivity, cards,null)
        ui.rvList2.adapter = MenuAdapter(this@MainActivity, cards,ui.bottomSheetLayout)
        ui.goToCartButton.setOnClickListener { _ ->
            ui.bottomSheetLayout.scrollable = null
            ui.bottomSheetLayout.toggle()
        }
        ui.bottomSheetLayout.setOnProgressListener { progress -> rotateArrow(progress) }



    }

    fun isRecyclerScrollable(): Boolean {
        val layoutManager = ui.rvList2.layoutManager as LinearLayoutManager
        val adapter = ui.rvList2.adapter
        return if (adapter == null) false else layoutManager.findLastCompletelyVisibleItemPosition() < adapter.itemCount - 1
    }
    private fun rotateArrow(progress: Float) {
       // ui.imageViewArrow.rotation = -180 * progress
        if (progress == 1f) {
            ui.goToCartButton.text = "Ver Catalogo"
            ui.bottomSheetLayout.scrollable = ui.rvList
        } else {
            ui.goToCartButton.text = "Ver Carrinho"
            ui.bottomSheetLayout.scrollable = null
        }


    }
}
