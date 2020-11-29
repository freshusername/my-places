package com.unrevealedinc.myplaces

import androidx.room.Room
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.unrevealedinc.myplaces.data.local.PlacesDao
import com.unrevealedinc.myplaces.data.local.PlacesDb
import com.unrevealedinc.myplaces.data.entities.Place
import org.junit.Before
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*
import java.io.IOException

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(AndroidJUnit4::class)
class PlacesDatabaseTest {

    private lateinit var placesDao: PlacesDao
    private lateinit var db: PlacesDb

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getInstrumentation().targetContext
        // Using an in-memory database because the information stored here disappears when the
        // process is killed.
        db = Room.inMemoryDatabaseBuilder(context, PlacesDb::class.java)
            // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
            .build()
        placesDao = db.placesDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    suspend fun insertAndGetNight() {
        val place = Place()
        placesDao.insert(place)
        val latestPlace = placesDao.getLatest()
        assertEquals(latestPlace?.name, "latest place")
    }
}
