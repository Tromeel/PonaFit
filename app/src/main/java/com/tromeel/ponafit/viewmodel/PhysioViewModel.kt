package com.tromeel.ponafit.viewmodel

import android.app.Application
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tromeel.ponafit.model.Physio
import com.tromeel.ponafit.data.PhysioDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream

class PhysioViewModel(app: Application) : AndroidViewModel(app) {

    private val context = app.applicationContext
    private val physioDao = PhysioDatabase.getDatabase(app).physioDao()

    val allPhysio: LiveData<List<Physio>> = physioDao.getAllPhysio()

    fun addPhysio(name: String, price: Double, phone: String, imageUri: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val savedImagePath = saveImageToInternalStorage(Uri.parse(imageUri))
            val newPhysio = Physio(
                name = name,
                price = price,
                phone = phone,
                imagePath = savedImagePath // use saved image path
            )
            physioDao.insertPhysio(newPhysio)
        }
    }

    fun updatePhysio(updatedPhysio: Physio) {
        viewModelScope.launch(Dispatchers.IO) {
            physioDao.updatePhysio(updatedPhysio)
        }
    }

    fun deletePhysio(physio: Physio) {
        viewModelScope.launch(Dispatchers.IO) {
            // Delete image from storage
            deleteImageFromInternalStorage(physio.imagePath)
            physioDao.deletePhysio(physio)
        }
    }

    // Save image permanently to internal storage
    private fun saveImageToInternalStorage(uri: Uri): String {
        val inputStream: InputStream? = context.contentResolver.openInputStream(uri)
        val fileName = "IMG_${System.currentTimeMillis()}.jpg"
        val file = File(context.filesDir, fileName)

        inputStream?.use { input ->
            FileOutputStream(file).use { output ->
                input.copyTo(output)
            }
        }

        return file.absolutePath
    }

    private fun deleteImageFromInternalStorage(path: String) {
        try {
            val file = File(path)
            if (file.exists()) {
                file.delete()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}