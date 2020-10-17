@file:Suppress("NOTHING_TO_INLINE", "unused")
package com.unrevealedinc.myplaces.ui.extensions

import android.view.View
import androidx.annotation.DimenRes
import org.jetbrains.anko.dip
import java.util.*

internal fun View.generateId() {
    id = Random().nextInt(Int.MAX_VALUE)
}

internal inline fun View.dip(@DimenRes dimenRes: Int): Int = context.dip(resources.getDimension(dimenRes))