package com.unrevealedinc.myplaces.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.unrevealedinc.myplaces.data.entities.Place

@Dao
interface PlacesDao {
    @Insert
    fun insert(place: Place)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(places: List<Place>)

    @Update
    fun update(place: Place)

    @Query("SELECT * FROM tblPlaces p ORDER BY p.modifiedOn DESC")
    fun getAllPlaces(): LiveData<List<Place>>

    @Query("SELECT * FROM tblPlaces WHERE id = :id")
    fun getPlace(id: Int): LiveData<Place>

    @Query("delete from tblPlaces")
    fun deleteAll()

    @Query("SELECT * from tblPlaces order by modifiedOn desc limit 1")
    suspend fun getLatest() : Place?

}