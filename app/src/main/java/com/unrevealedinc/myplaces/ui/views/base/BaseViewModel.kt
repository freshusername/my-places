package com.unrevealedinc.myplaces.ui.views.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.unrevealedinc.myplaces.domain.core.AppException
import com.unrevealedinc.myplaces.ui.common.ActionLiveData

internal open class BaseViewModel : ViewModel() {

    /**
     * Base live variables, that are available for observing in [BaseActivity] or [BaseFragment].
     */
    val isProgressVisible = MutableLiveData<Boolean>()
    val onShowError = MutableLiveData<AppException>()
    val onShowMessage = MutableLiveData<Any>()
    val onCloseKeyboard = ActionLiveData<Unit>()
    val onClosePage = ActionLiveData<Unit>()

    fun onClosePageClick() {
        onClosePage.call()
    }
}