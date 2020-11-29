package com.unrevealedinc.myplaces.ui.views.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe


@Suppress("UNCHECKED_CAST")
internal abstract class BaseFragmentT<V : ViewDataBinding, VM : BaseViewModel> : Fragment(),
    IView {

    private val baseActivity get() = (activity as? BaseActivity<*, *>)
    private val layoutRes get() = depends.layout
    private val viewModelClass get() = depends.viewModelClass as VM

    protected lateinit var binding: V
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = with(DataBindingUtil.inflate<V>(layoutInflater, layoutRes, container, false)) {
        binding = this
        lifecycleOwner = this@BaseFragmentT.viewLifecycleOwner
        initUI()
        root
    }

    protected open fun VM.observeViewModel() {
        /* Default implementation */
    }

    protected open fun V.initUI() {
        /* Default implementation */
    }

    protected inline fun <P> LiveData<P>.observe(crossinline observerBody: (P.() -> Unit)) {
        observe(viewLifecycleOwner) {
            observerBody(it)
        }
    }
}