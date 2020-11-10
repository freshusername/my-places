package com.unrevealedinc.myplaces.domain.core

import androidx.annotation.StringRes

internal data class StringResource(
    @StringRes val messageResId: Int,
    val args: Array<Any> = emptyArray()
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StringResource

        if (messageResId != other.messageResId) return false
        if (!args.contentEquals(other.args)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = messageResId
        result = 31 * result + args.contentHashCode()
        return result
    }
}