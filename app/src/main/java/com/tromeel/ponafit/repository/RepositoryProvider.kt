package com.tromeel.ponafit.repository

import android.content.Context
import com.tromeel.ponafit.data.DatabaseProvider

object RepositoryProvider {
    @Volatile
    private var INSTANCE: ExerciseRepository? = null

    fun getRepository(context: Context): ExerciseRepository {
        return INSTANCE ?: synchronized(this) {
            val dao = DatabaseProvider.getDatabase(context).exerciseTrackingDao()
            val instance = ExerciseRepository(dao)
            INSTANCE = instance
            instance
        }
    }
}
