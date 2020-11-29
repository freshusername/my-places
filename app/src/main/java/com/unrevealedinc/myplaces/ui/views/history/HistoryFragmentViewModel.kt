package com.unrevealedinc.myplaces.ui.views.history

import android.util.Log
import com.unrevealedinc.myplaces.ui.views.base.BaseViewModel

internal class HistoryFragmentViewModel : BaseViewModel() {
    private lateinit var historyPlacesList: MutableList<String>
    init {
        Log.i("HistoryFragmentVM", "HistoryFragmentViewModel created!")
    }
}