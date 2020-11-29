package com.unrevealedinc.myplaces.ui.views

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.unrevealedinc.myplaces.data.local.PlacesDao
import com.unrevealedinc.myplaces.ui.views.bookmarks.BookmarksFragmentViewModel

class ViewModelFactory (
    private val dataSource: PlacesDao,
    private val app: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(BookmarksFragmentViewModel::class.java)) {
            return BookmarksFragmentViewModel(dataSource, app) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}