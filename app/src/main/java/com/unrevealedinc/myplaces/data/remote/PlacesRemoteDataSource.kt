package com.unrevealedinc.myplaces.data.remote

import javax.inject.Inject

class PlacesRemoteDataSource @Inject constructor(
    private val placesService: PlacesService
): BaseDataSource() {

    suspend fun getPlaces() = getResult { placesService.getAllPlaces()}
    suspend fun getNearbyPlaces(lat: Double, lng: Double, radius: UInt) = getResult { placesService.getNearbyPlaces(lat, lng, radius)}
    suspend fun getPlace(id: Long) = getResult { placesService.getPlace(id) }
}