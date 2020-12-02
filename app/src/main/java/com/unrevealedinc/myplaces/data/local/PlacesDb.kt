package com.unrevealedinc.myplaces.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.unrevealedinc.myplaces.data.entities.Place

@Database(entities = [Place::class], version = 3, exportSchema = false)
abstract class PlacesDb : RoomDatabase() {

    abstract fun placesDao(): PlacesDao

    companion object {
        @Volatile private var instance: PlacesDb? = null

        fun getDatabase(context: Context): PlacesDb =
            instance ?: synchronized(this) { instance ?: buildDatabase(context).also { instance = it } }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, PlacesDb::class.java, "placesDb")
                .fallbackToDestructiveMigration()
                .build()
    }
}
