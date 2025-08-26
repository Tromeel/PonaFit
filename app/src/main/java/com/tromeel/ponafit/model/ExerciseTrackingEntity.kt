package com.tromeel.ponafit.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "exercise_tracking")
data class ExerciseTrackingEntity(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),

    val exerciseName: String,   // Unique exercise name
    val duration: String,       // e.g., "20–30 seconds"
    val completedAt: Long = System.currentTimeMillis(),

    val mainCategory: String,   // e.g., "Stretching Exercises", "Home Exercises"
    val subCategory: String     // e.g., "Full Body", "Upper Body", "Lower Body"
)
