package com.tromeel.ponafit.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tromeel.ponafit.model.ExerciseTrackingEntity

@Database(
    entities = [ExerciseTrackingEntity::class],
    version = 2, // bumped from 1 → 2 after adding "type" column
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun exerciseTrackingDao(): ExerciseTrackingDao
}
