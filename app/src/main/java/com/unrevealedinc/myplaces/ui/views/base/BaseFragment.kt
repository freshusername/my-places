package com.unrevealedinc.myplaces.ui.views.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.observe
import com.unrevealedinc.myplaces.domain.core.StringResource
import com.unrevealedinc.myplaces.ui.extensions.hideSoftKeyboard
import org.jetbrains.anko.support.v4.toast
import org.koin.androidx.viewmodel.ext.android.getViewModel


@Suppress("UNCHECKED_CAST")
internal abstract class BaseFragmentT<V : ViewDataBinding, VM : BaseViewModel> : Fragment(),
    IView {

    private val baseActivity get() = (activity as? BaseActivity<*, *>)
    private val layoutRes get() = depends.layout
    private val viewModelClass get() = depends.viewModelClass as VM

    protected lateinit var binding: V
    protected val viewModel by lazy { getViewModel(depends.viewModelClass) as VM }

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.apply {
            onShowMessage.observe {
                when (this) {
                    is String -> toast(this)
                    is StringResource -> toast(messageResId)
                }
            }
            onShowError.observe { toast(message ?: getString(messageResource.messageResId)) }
            onCloseKeyboard.observe { baseActivity?.hideSoftKeyboard() }
            observeViewModel()
        }
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