package com.unrevealedinc.myplaces.ui.common

import androidx.lifecycle.MutableLiveData

internal inline fun MutableLiveData<Boolean>?.withProgress(block: () -> Unit) {
    if (this?.value != true) {
        this?.value = true
    }
    block.invoke()
    this?.value = false
}

internal operator fun MutableLiveData<Boolean>.not() : Boolean {
    return this.value == false
}

internal val MutableLiveData<String>.valueOrEmpty: String
    get() = value.orEmpty()