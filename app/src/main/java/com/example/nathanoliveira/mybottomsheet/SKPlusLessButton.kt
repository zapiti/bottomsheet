package com.example.nathanoliveira.mybottomsheet

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.content.ContextCompat
import android.text.InputType
import android.view.Gravity
import android.view.View
import android.view.ViewManager
import android.widget.EditText
import android.widget.ImageView
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.ankoView
import org.jetbrains.anko.sdk25.coroutines.onClick


@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
fun ViewManager.skPlusLessButton(): SKPlusLessButton = skPlusLessButton {}

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
inline fun ViewManager.skPlusLessButton(init: (@AnkoViewDslMarker SKPlusLessButton).() -> Unit): SKPlusLessButton =
        ankoView({ ctx: Context -> SKPlusLessButton(ctx) }, theme = 0) { init() }

@RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
class SKPlusLessButton(ctx: Context) : _RelativeLayout(ctx) {

    lateinit var editable: EditText
    lateinit var btnLess: ImageView
    lateinit var btnPluss: ImageView

    init {
        id = View.generateViewId()
        var count = 0

        isClickable = true
        linearLayout {
            id = View.generateViewId()
            relativeLayout {
                id = View.generateViewId()
                btnLess = imageView {
                    isClickable = true
                    id = View.generateViewId()
                    id = View.generateViewId()
                    setImageResource(R.drawable.ic_less)
                    onClick {
                        count = try {
                            editable.text.toString().toInt()
                        } catch (e: Exception) {
                            0
                        }

                        if (count in 1..999998)
                            count--
                        editable.setText(count.toString())

                    }
                    background = ContextCompat.getDrawable(getContext(),R.drawable.ic_round)
                    setColorFilter(Color.WHITE)
                }.lparams {
                    width = dip(24)
                    height = dip(24)
                    centerVertically()
                    alignParentStart()
                }

                editable = editText {
                    maxLines = 1
                    isFocusable = false
                    id = View.generateViewId()
                    textSize = 18f
                    setText(count.toString())
                    inputType = InputType.TYPE_CLASS_NUMBER

                    textColor = Color.GRAY
                }.lparams(wrapContent) {
                    gravity = Gravity.CENTER_VERTICAL
                    marginStart = dip(10)
                    marginEnd = dip(10)
                    rightOf(btnLess)
                    centerVertically()
                    width = wrapContent
                    height = wrapContent
                }

                btnPluss = imageView {
                    isClickable = true
                    background = ContextCompat.getDrawable(getContext(),R.drawable.ic_round)
                    id = View.generateViewId()
                    generateViewId()
                    onClick {
                        count = try {
                            editable.text.toString().toInt()
                        } catch (e: Exception) {
                            0
                        }
                        if (count in 0..999998)
                            count++
                        editable.setText(count.toString())
                    }
                    setImageResource(R.drawable.ic_add)
                    setColorFilter(Color.WHITE)
                }.lparams {
                    width = dip(24)
                    height = dip(24)
                    centerVertically()
                    rightOf(editable)

                }


            }.lparams {
                height = dip(48)
            }
        }.lparams {
            width = wrapContent
            height = dip(48)
            topMargin = dip(5)
            bottomMargin = dip(5)
        }

    }
}