package com.tromeel.ponafit.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "exercise_tracking")
data class ExerciseTrackingEntity(
    @PrimaryKey val id: String = UUID.randomUUID().toString(),
    val exerciseName: String,
    val duration: String,
    val completedAt: Long = System.currentTimeMillis()
)

