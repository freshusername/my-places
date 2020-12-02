package com.unrevealedinc.myplaces.ui.views.placeDetails

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.unrevealedinc.myplaces.data.entities.Place
import com.unrevealedinc.myplaces.data.repository.PlacesRepository
import com.unrevealedinc.myplaces.utils.Resource

class PlaceDetailViewModel @ViewModelInject constructor(
    private val repository: PlacesRepository
) : ViewModel() {

    private val _id = MutableLiveData<Long>()

    private val _place  = _id.switchMap { id ->
        repository.getPlace(id)
    }
    var place: LiveData<Resource<Place>> = _place


    fun start(id: Long) {
        _id.value = id
    }
}
