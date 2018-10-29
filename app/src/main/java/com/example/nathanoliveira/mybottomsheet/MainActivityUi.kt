package com.example.nathanoliveira.mybottomsheet

import android.annotation.TargetApi
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.*
import com.example.nathanoliveira.mybottomsheet.BottomSheetLayoutView
import com.example.nathanoliveira.mybottomsheet.MainActivity
import com.example.nathanoliveira.mybottomsheet.bottomSheetLayoutView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivityUi : AnkoComponent<MainActivity> {

    lateinit var bottomSheetLayout: BottomSheetLayoutView

    lateinit var cardsGridView:GridView
    lateinit var rvList: RecyclerView
    lateinit var rvList2:RecyclerView


    lateinit var listView: RecyclerView

    lateinit var goToCartContainer: RelativeLayout
    lateinit var qtdTextView: TextView
    lateinit var moneyTextView: TextView
    lateinit var goToCartButton : TextView
    lateinit var testRelative :RelativeLayout

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

         relativeLayout {


             testRelative =   relativeLayout(){
                 id = View.generateViewId()
                backgroundColorResource = R.color.colorPrimary

                 textView("Catalogo "){
                     textColor = Color.WHITE
                     textSize = 18f
                 }.lparams{
                     centerVertically()
                     marginStart =  dip(15)
                 }

            }.lparams(matchParent,dip(56)){

            }


            rvList = recyclerView {
                layoutManager = GridLayoutManager(context, 2)
//                layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
                overScrollMode = View.OVER_SCROLL_NEVER
            }.lparams(matchParent, matchParent) {

                below(testRelative)
                setMargins(dip(8), 0, dip(8), 0)
            }

            bottomSheetLayout = bottomSheetLayoutView {
                this.collapsedHeight = dip(70)


                backgroundResource = R.color.colorPrimary
                id = View.generateViewId()


                linearLayout {

                    orientation = LinearLayout.VERTICAL

                    linearLayout {
                        relativeLayout {
                            id = View.generateViewId()


                            onClick {
                                goToCartButton.callOnClick()
                            }
                            backgroundColor = ContextCompat.getColor(context, R.color.colorPrimary)

                            moneyTextView = textView("RS110,00") {
                                textSize = 18f
                                textColor = Color.WHITE
                                id = View.generateViewId()
                            }.lparams {
                                centerVertically()
                                alignParentStart()
                                marginStart = dip(15)
                            }
                            qtdTextView = textView("(0)") {
                                id = View.generateViewId()
                                textSize = 18f
                                textColor = Color.LTGRAY

                            }.lparams {
                                centerVertically()
                                rightOf(moneyTextView)
                                marginStart = dip(2)
                            }
                            goToCartButton = textView("Ver Carrinho") {
                                id = View.generateViewId()
                                isClickable = true


                                textSize = 18f
                                textColor = Color.WHITE

                            }.lparams {
                                centerVertically()
                                alignParentEnd()
                                marginEnd = dip(10)
                            }
                        }.lparams(matchParent, matchParent){

                        }
                        }.lparams(width = matchParent, height = dip(70))
                    relativeLayout {
                        elevation = 15f
                        backgroundColor = Color.WHITE

                        frameLayout{
                            rvList2 = recyclerView {
                                //   layoutManager = GridLayoutManager(context, 2)
                                layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
                                overScrollMode = View.OVER_SCROLL_NEVER
                            }.lparams(matchParent, matchParent) {
                                setMargins(dip(8), 0, dip(8), 0)
                            }
                        }
                    }.lparams(width = matchParent, height = matchParent)
                }

            }.lparams(width = matchParent, height = matchParent) {
                alignParentBottom()

            }
        }

    }

}