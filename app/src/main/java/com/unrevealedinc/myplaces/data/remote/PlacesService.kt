package com.unrevealedinc.myplaces.data.remote

import com.unrevealedinc.myplaces.data.entities.Place
import com.unrevealedinc.myplaces.data.entities.PlaceList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PlacesService {
    //TODO: change uri
    @GET("/api/v0/places/search?searchKey=stone")
    suspend fun getAllPlaces() : Response<PlaceList> //Response<PlaceContainer>

    @GET("place/{id}")
    suspend fun getPlace(@Path("id") id: Int): Response<Place>
}