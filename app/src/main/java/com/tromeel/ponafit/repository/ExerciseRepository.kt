package com.tromeel.ponafit.repository

import com.tromeel.ponafit.data.ExerciseTrackingDao
import com.tromeel.ponafit.model.ExerciseTrackingEntity
import kotlinx.coroutines.flow.Flow

class ExerciseRepository(private val dao: ExerciseTrackingDao) {

    suspend fun insertTracking(entity: ExerciseTrackingEntity) = dao.insertTracking(entity)

    fun getAllTracking(): Flow<List<ExerciseTrackingEntity>> = dao.getAllTracking()

    suspend fun clearAll() = dao.clearAll()

    suspend fun deleteExerciseByName(name: String) = dao.deleteExerciseByName(name)

    // ✅ Get exercises by main category (e.g. "Home Exercises", "Rehab")
    fun getTrackingByMainCategory(mainCategory: String): Flow<List<ExerciseTrackingEntity>> =
        dao.getTrackingByMainCategory(mainCategory)

    // ✅ Get exercises by subcategory (e.g. "Upperbody Workouts", "Knee Rehab")
    fun getTrackingBySubCategory(subCategory: String): Flow<List<ExerciseTrackingEntity>> =
        dao.getTrackingBySubCategory(subCategory)
}
