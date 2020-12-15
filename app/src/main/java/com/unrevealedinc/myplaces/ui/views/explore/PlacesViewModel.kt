package com.unrevealedinc.myplaces.ui.views.explore

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.unrevealedinc.myplaces.data.entities.Place
import com.unrevealedinc.myplaces.data.repository.PlacesRepository
import com.unrevealedinc.myplaces.utils.Resource
import timber.log.Timber

class PlacesViewModel @ViewModelInject constructor(
    private val repository: PlacesRepository
) : ViewModel() {

    val places: LiveData<Resource<List<Place>>> = repository.getPlaces()
    var count : Int = 0

    fun onFabClicked()
    {
        Timber.i("FAB clicked!")
    }
}