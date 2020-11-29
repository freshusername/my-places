package com.unrevealedinc.myplaces.di.modules

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.unrevealedinc.myplaces.BuildConfig
import com.unrevealedinc.myplaces.data.local.PlacesDao
import com.unrevealedinc.myplaces.data.local.PlacesDb
import com.unrevealedinc.myplaces.data.remote.PlacesRemoteDataSource
import com.unrevealedinc.myplaces.data.remote.PlacesService
import com.unrevealedinc.myplaces.data.repository.PlacesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson) : Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.API_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun providePlacesService(retrofit: Retrofit): PlacesService = retrofit.create(PlacesService::class.java)

    @Singleton
    @Provides
    fun providePlacesRemoteDataSource(placesService: PlacesService) = PlacesRemoteDataSource(placesService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = PlacesDb.getDatabase(appContext)

    @Singleton
    @Provides
    fun providePlacesDao(db: PlacesDb) = db.placesDao()

    @Singleton
    @Provides
    fun provideRepository(remoteDataSource: PlacesRemoteDataSource,
                          localDataSource: PlacesDao) =
        PlacesRepository(remoteDataSource, localDataSource)
}