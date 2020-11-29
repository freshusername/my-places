package com.unrevealedinc.myplaces.ui.extensions

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import com.unrevealedinc.myplaces.R
import com.unrevealedinc.myplaces.ui.enum.AnimationType

internal fun FragmentActivity.hideSoftKeyboard() {
    (getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)
        ?.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
}

internal fun FragmentTransaction.setTransition(animationType: AnimationType) {
    val (animIn, animOut) = when (animationType) {
        AnimationType.SLIDE_LEFT -> R.anim.slide_left_enter to R.anim.slide_left_exit
        AnimationType.SLIDE_RIGHT -> R.anim.slide_in_left to R.anim.slide_out_right
    }

    setCustomAnimations(animIn, animOut)
}