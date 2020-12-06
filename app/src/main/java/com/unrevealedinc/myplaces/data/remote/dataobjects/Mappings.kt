package com.unrevealedinc.myplaces.data.remote.dataobjects

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.JsonClass
import com.unrevealedinc.myplaces.data.entities.Place

@JsonClass(generateAdapter = true)
data class PlaceContainer(val places: List<PlaceResponse>)

@JsonClass(generateAdapter = true)
data class PlaceResponse(
    val id: Long = 0L,
    val name: String? = "latest place",
    val isOpen: Boolean = true,
    val address: String? = null,
    val location: Location,
    @SerializedName("photos")
    val base64Photos: MutableList<Photo>,
    val icon: String? = null,
    val types: MutableList<String>,
    val modifiedOn: Long = System.currentTimeMillis() //TODO: change to datetime
)

data class PlaceResponseList(
    val placeResponses: List<PlaceResponse>
)

fun PlaceContainer.asDomainModel(): List<Place> {
    return places.map {
        Place(
            id = it.id,
            address = it.address,
            base64Img = it.base64Photos.firstOrNull()?.src,
            icon = it.icon,
            isOpen = it.isOpen,
            lat = it.location.lat,
            lng = it.location.lng,
            modifiedOn = it.modifiedOn,
            name = it.name,
            type = it.types.firstOrNull()
        )
    }
}
