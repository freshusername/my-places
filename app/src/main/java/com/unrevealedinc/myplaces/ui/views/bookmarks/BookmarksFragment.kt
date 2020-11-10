package com.unrevealedinc.myplaces.ui.views.bookmarks

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe
import com.unrevealedinc.myplaces.R
import com.unrevealedinc.myplaces.databinding.FragmentBookmarksBinding
import com.unrevealedinc.myplaces.domain.core.StringResource
import com.unrevealedinc.myplaces.ui.extensions.hideSoftKeyboard
import com.unrevealedinc.myplaces.ui.views.base.*
import com.unrevealedinc.myplaces.ui.views.base.BaseFragmentT
import com.unrevealedinc.myplaces.ui.views.base.Depends
import org.jetbrains.anko.support.v4.toast
import org.koin.androidx.viewmodel.ext.android.getViewModel

@SuppressLint("NonConstantResourceId")
@Depends(R.layout.fragment_bookmarks, BookmarksFragmentViewModel::class)
internal class BookmarksFragment : BaseFragmentT<FragmentBookmarksBinding, BookmarksFragmentViewModel>()
