package com.unrevealedinc.myplaces.ui.views.bookmarks

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.unrevealedinc.myplaces.data.local.PlacesDao

internal class BookmarksFragmentViewModel(
    val db: PlacesDao,
    app: Application
        ) : AndroidViewModel(app) {

    private lateinit var bookmarkedPlacesList: MutableList<String>
    init {
        Log.i("BookmarksFragmentVM", "BookmarksFragmentViewModel created!")
    }
}