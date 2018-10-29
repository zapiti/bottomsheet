package com.example.nathanoliveira.mybottomsheet

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.find
import org.jetbrains.anko.imageResource
import org.jetbrains.anko.sdk25.coroutines.onClick

class MenuAdapter(val context: Context, var mDataSet: ArrayList<String>,val buttomSheet: BottomSheetLayoutView?) : RecyclerView.Adapter<MenuAdapter.MyViewHolder>() {
    private val mContext = AnkoContext.createReusable(context, this)
    private var click: ((position: Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(MenuAdapterUi().createView(mContext))
    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {




//        if (position == 0){
//            buttomSheet?.scrollable = null
//        }else{
//            buttomSheet?.scrollable = View(context)
//        }

        val card = mDataSet[position]
        if (card != null) {
            holder.iconImageView.imageResource = R.drawable.produto

            holder.nameTextView.text = "VEJA"
            holder.descLayout.text = "Produto de limpesa."
            holder.valueLayout.text = "R$100,00 - UN"

            holder.containerRelativeLayout.onClick {
                if (click != null) {
                    click!!(position)
                }
            }
            if (position == 0 || position == 1) {
                holder.containerRelativeLayout.setPadding(0, 20, 0, 0)
            }
            if (position == mDataSet.size || position == mDataSet.size - 1) {
                holder.containerRelativeLayout.setPadding(0, 0, 0, 50)
            }
        }
    }

    fun onClick(click: (position: Int) -> Unit) {
        this.click = click
    }


    /**
     * Layout de cada item da lista
     */
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var iconImageView = itemView.find<ImageView>(MenuAdapterUi.IMAGE)
        internal var nameTextView = itemView.find<TextView>(MenuAdapterUi.NAME)

        internal var descLayout = itemView.find<TextView>(MenuAdapterUi.DESCRIPTION)
        internal var valueLayout = itemView.find<TextView>(MenuAdapterUi.VALUE)

        internal var containerRelativeLayout = itemView.find<RelativeLayout>(MenuAdapterUi.RELATIVE)
    }
}