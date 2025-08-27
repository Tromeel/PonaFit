package com.tromeel.ponafit.model


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "physio")
data class Physio(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val price: Double,
    val phone: String,
    val imagePath: String
)