package com.unrevealedinc.myplaces.data.entities

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblPlaces")
data class Place (
    @PrimaryKey(autoGenerate = true)
    @NonNull
    val id: Long = 0L,
    val name: String? = "latest place",
    val address: String? = null,
    val isOpen: Boolean = true,
    val lat: Double = 0.0,
    val lng: Double = 0.0,
    val icon: String? = null,
    val type: String? = null,
    val base64Img: String? = null,
    val photoReference: String? = null,
    val modifiedOn: Long = System.currentTimeMillis()
)