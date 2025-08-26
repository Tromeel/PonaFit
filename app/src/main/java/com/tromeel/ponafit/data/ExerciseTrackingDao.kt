package com.tromeel.ponafit.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.tromeel.ponafit.model.ExerciseTrackingEntity
import kotlinx.coroutines.flow.Flow
@Dao
interface ExerciseTrackingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTracking(tracking: ExerciseTrackingEntity)

    @Query("SELECT * FROM exercise_tracking ORDER BY completedAt DESC")
    fun getAllTracking(): Flow<List<ExerciseTrackingEntity>>

    @Query("DELETE FROM exercise_tracking")
    suspend fun clearAll()

    @Query("DELETE FROM exercise_tracking WHERE exerciseName = :name")
    suspend fun deleteExerciseByName(name: String)

    // ✅ New queries for HistoryScreen filtering
    @Query("SELECT * FROM exercise_tracking WHERE mainCategory = :mainCategory ORDER BY completedAt DESC")
    fun getTrackingByMainCategory(mainCategory: String): Flow<List<ExerciseTrackingEntity>>

    @Query("SELECT * FROM exercise_tracking WHERE subCategory = :subCategory ORDER BY completedAt DESC")
    fun getTrackingBySubCategory(subCategory: String): Flow<List<ExerciseTrackingEntity>>


    @Query("SELECT EXISTS(SELECT 1 FROM exercise_tracking WHERE exerciseName = :name)")
    fun isExerciseTracked(name: String): Flow<Boolean>

}
