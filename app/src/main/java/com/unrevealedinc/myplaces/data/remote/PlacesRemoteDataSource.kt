package com.unrevealedinc.myplaces.data.remote

import javax.inject.Inject

class PlacesRemoteDataSource @Inject constructor(
    private val placesService: PlacesService
): BaseDataSource() {

    //TODO: placesService.getAllPlaces().body()?.asDomainModel()
    suspend fun getPlaces() = getResult { placesService.getAllPlaces()}
    suspend fun getPlace(id: Int) = getResult { placesService.getPlace(id) }
}