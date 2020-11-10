package com.unrevealedinc.myplaces.ui.di

import com.unrevealedinc.myplaces.ui.di.modules.applicationIdentifiersDependencies
import com.unrevealedinc.myplaces.ui.di.modules.viewModelModule

internal fun provideModules() = arrayOf(
    applicationIdentifiersDependencies,
    viewModelModule
)