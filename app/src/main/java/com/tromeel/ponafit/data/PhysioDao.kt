package com.tromeel.ponafit.data


import androidx.lifecycle.LiveData
import androidx.room.*
import com.tromeel.ponafit.model.Physio


@Dao
interface PhysioDao {
    @Query("SELECT * FROM physio")
    fun getAllPhysio(): LiveData<List<Physio>>

    @Insert
    suspend fun insertPhysio(physio: Physio)

    @Update
    suspend fun updatePhysio(physio: Physio)

    @Delete
    suspend fun deletePhysio(physio: Physio)
}