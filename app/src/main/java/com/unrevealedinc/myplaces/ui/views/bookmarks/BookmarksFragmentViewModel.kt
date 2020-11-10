package com.unrevealedinc.myplaces.ui.views.bookmarks

import android.util.Log
import com.unrevealedinc.myplaces.ui.views.base.BaseViewModel

internal class BookmarksFragmentViewModel : BaseViewModel() {
    private lateinit var bookmarksList: MutableList<String>
    init {
        Log.i("BookmarksFragmentVM", "BookmarksFragmentViewModel created!")
    }
}