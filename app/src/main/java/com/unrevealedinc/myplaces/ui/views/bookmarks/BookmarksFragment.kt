package com.unrevealedinc.myplaces.ui.views.bookmarks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.unrevealedinc.myplaces.R
import com.unrevealedinc.myplaces.databinding.FragmentBookmarksBinding

class BookmarksFragment : Fragment() {

    private lateinit var binding: FragmentBookmarksBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_bookmarks, container, false)

        return binding.root
    }
}