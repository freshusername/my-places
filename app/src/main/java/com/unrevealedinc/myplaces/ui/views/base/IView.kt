package com.unrevealedinc.myplaces.ui.views.base

internal interface IView {
    val depends
        get() = javaClass.getAnnotation(Depends::class.java)
            ?: throw Depends.AbsentDependsAnnotation()
}