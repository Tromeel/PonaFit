package com.tromeel.ponafit.repository

import com.tromeel.ponafit.data.ExerciseTrackingDao
import com.tromeel.ponafit.model.ExerciseTrackingEntity
import kotlinx.coroutines.flow.Flow

class ExerciseRepository(private val dao: ExerciseTrackingDao) {

    suspend fun insertTracking(entity: ExerciseTrackingEntity) = dao.insertTracking(entity)

    fun getAllTracking(): Flow<List<ExerciseTrackingEntity>> = dao.getAllTracking()

    suspend fun clearAll() = dao.clearAll()

    // ✅ Add repository method to delete exercise by name
    suspend fun deleteExerciseByName(name: String) = dao.deleteExerciseByName(name)
}
