package com.example.nathanoliveira.mybottomsheet

import android.content.Context
import android.view.ViewManager
import org.jetbrains.anko.AnkoViewDslMarker
import org.jetbrains.anko.custom.ankoView

fun ViewManager.bottomSheetLayoutView(): BottomSheetLayoutView = bottomSheetLayoutView {}
inline fun ViewManager.bottomSheetLayoutView(init: (@AnkoViewDslMarker BottomSheetLayoutView).() -> Unit): BottomSheetLayoutView =
        ankoView({ ctx: Context -> BottomSheetLayoutView(ctx) }, theme = 0) { init() }

class BottomSheetLayoutView(ctx: Context) : BottomSheetLayout(ctx) {
    init {

    }
}