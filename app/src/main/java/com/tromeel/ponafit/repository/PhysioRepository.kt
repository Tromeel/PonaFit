package com.tromeel.ponafit.repository

import android.content.Context
import com.tromeel.ponafit.model.Physio
import com.tromeel.ponafit.data.PhysioDatabase

class PhysioRepository(context: Context) {
    private val productDao = PhysioDatabase.getDatabase(context).physioDao()

    suspend fun insertProduct(product: Physio) {
        productDao.insertPhysio(product)
    }

    fun getAllProducts() = productDao.getAllPhysio()

    suspend fun deleteProduct(product: Physio) = productDao.deletePhysio(product)
}
