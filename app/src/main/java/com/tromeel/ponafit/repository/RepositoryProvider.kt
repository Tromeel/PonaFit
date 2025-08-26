package com.tromeel.ponafit.repository

import com.tromeel.ponafit.data.DatabaseProvider


import android.content.Context


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
