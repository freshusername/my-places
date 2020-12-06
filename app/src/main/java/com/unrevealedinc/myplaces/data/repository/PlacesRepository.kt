package com.unrevealedinc.myplaces.data.repository

import com.unrevealedinc.myplaces.data.local.PlacesDao
import com.unrevealedinc.myplaces.data.remote.PlacesRemoteDataSource
import com.unrevealedinc.myplaces.utils.performGetOperation
import javax.inject.Inject

class PlacesRepository @Inject constructor(
    private val remoteDataSource: PlacesRemoteDataSource,
    private val localDataSource: PlacesDao
) {

    fun getPlace(id: Long) = performGetOperation(
        databaseQuery = { localDataSource.getPlace(id) },
        networkCall = { remoteDataSource.getPlace(id) },
        saveCallResult = { localDataSource.insert(it) }
    )

    fun getPlaces() = performGetOperation(
        databaseQuery = { localDataSource.getAllPlaces() },
        networkCall = { remoteDataSource.getPlaces() },
        saveCallResult = { localDataSource.insertAll(it.places) }
    )

    fun refreshPlaces() = performGetOperation(
        databaseQuery = { localDataSource.getAllPlaces() },
        networkCall = { remoteDataSource.getPlaces() },
        saveCallResult = { localDataSource.insertAll(it.places) }
    )
}