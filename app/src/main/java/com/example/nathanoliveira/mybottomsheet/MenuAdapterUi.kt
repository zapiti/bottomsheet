package com.example.nathanoliveira.mybottomsheet

import android.os.Build
import android.support.annotation.RequiresApi
import android.view.Gravity
import android.view.View
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

class MenuAdapterUi : AnkoComponent<MenuAdapter> {
    companion object {
        const val IMAGE = 1
        const val NAME = 2
        const val RELATIVE = 3
        const val DESCRIPTION = 4
        const val VALUE = 5
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun createView(ui: AnkoContext<MenuAdapter>) = with(ui) {
        relativeLayout {
            id = RELATIVE
            isClickable = true


            cardView {
                radius = dip(8).toFloat()

                relativeLayout {
                    padding = dip(10)

                    imageView {
                        id = IMAGE
                    }.lparams(matchParent, dip(50))

                    textView {
                        id = NAME

                    }.lparams(matchParent) {
                        below(IMAGE)
                        topMargin = dip(5)
                    }

                    textView {
                        id = DESCRIPTION

                    }.lparams(matchParent) {
                        below(NAME)
                        topMargin = dip(5)
                    }

                    textView {
                        id = VALUE

                    }.lparams(matchParent) {
                        below(DESCRIPTION)
                        topMargin = dip(5)
                    }

                    skPlusLessButton(){
                        id = View.generateViewId()
                    }.lparams(){
                        centerHorizontally()
                        below(VALUE)
                    }



                }.lparams(matchParent) {
                    gravity = Gravity.CENTER
                }
            }.lparams(matchParent) {
                margin = dip(5)

            }
        }
    }
}