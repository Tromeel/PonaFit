package com.tromeel.ponafit.data


import androidx.room.Database
import androidx.room.RoomDatabase
import com.tromeel.ponafit.model.ExerciseTrackingEntity

@Database(
    entities = [ExerciseTrackingEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exerciseTrackingDao(): ExerciseTrackingDao
}
