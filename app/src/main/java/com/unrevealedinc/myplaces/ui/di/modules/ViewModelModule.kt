package com.unrevealedinc.myplaces.ui.di.modules

import com.unrevealedinc.myplaces.ui.views.bookmarks.BookmarksFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val viewModelModule = module {
    //add ViewModels here
    viewModel { BookmarksFragmentViewModel() }
}