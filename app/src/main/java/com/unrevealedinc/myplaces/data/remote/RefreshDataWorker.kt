package com.unrevealedinc.myplaces.data.remote

import android.content.Context
import androidx.hilt.Assisted
import androidx.hilt.work.WorkerInject
import androidx.work.CoroutineWorker
import androidx.work.Operation
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.unrevealedinc.myplaces.data.local.PlacesDb.Companion.getDatabase
import com.unrevealedinc.myplaces.data.repository.PlacesRepository
import retrofit2.HttpException

class RefreshDataWorker constructor(
    private val repository: PlacesRepository,
    private val appContext: Context,
    private val params: WorkerParameters
) : CoroutineWorker(appContext, params) {

    companion object {
        const val WORK_NAME = "RefreshDataWorker"
    }

    override suspend fun doWork(): Result {
        return try {
            repository.refreshPlaces()
            Result.success()
        } catch (e: HttpException) {
            Result.retry()
        }
    }
}