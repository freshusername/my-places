package com.unrevealedinc.myplaces.ui.views.base

import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
internal annotation class Depends(
    val layout: Int,
    val viewModelClass: KClass<out BaseViewModel>
) {
    class AbsentDependsAnnotation : Exception("annotation class Depends is not present")
}
