package com.unrevealedinc.myplaces.ui.extensions

import android.view.ViewManager
import org.jetbrains.anko.AnkoViewDslMarker
import org.jetbrains.anko.imageView
import java.util.*

internal inline fun ViewManager.imageView(
    imageResource: Int,
    withId: Boolean = true,
    init: (@AnkoViewDslMarker android.widget.ImageView).() -> Unit
) = imageView(imageResource, init).apply {
    if (withId) {
        id = Random().nextInt(Int.MAX_VALUE)
    }
}