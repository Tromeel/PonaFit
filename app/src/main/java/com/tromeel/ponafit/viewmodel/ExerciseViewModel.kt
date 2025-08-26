package com.tromeel.ponafit.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tromeel.ponafit.model.ExerciseTrackingEntity
import com.tromeel.ponafit.repository.ExerciseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ExerciseViewModel(private val repo: ExerciseRepository) : ViewModel() {

    // All exercise tracking
    val allTracking = repo.getAllTracking()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    // Track exercise with categories
    fun trackExercise(
        name: String,
        duration: String,
        mainCategory: String,
        subCategory: String
    ) {
        viewModelScope.launch {
            repo.insertTracking(
                ExerciseTrackingEntity(
                    exerciseName = name,
                    duration = duration,
                    mainCategory = mainCategory,
                    subCategory = subCategory
                )
            )
        }
    }

    // Get tracking filtered by main category
    fun getTrackingByMainCategory(mainCategory: String): Flow<List<ExerciseTrackingEntity>> {
        return repo.getTrackingByMainCategory(mainCategory)
    }

    // Get tracking filtered by subcategory
    fun getTrackingBySubCategory(subCategory: String): Flow<List<ExerciseTrackingEntity>> {
        return repo.getTrackingBySubCategory(subCategory)
    }

    // Delete specific exercise by name
    fun removeExerciseFromHistory(name: String) {
        viewModelScope.launch {
            repo.deleteExerciseByName(name)
        }
    }

    // Clear all history
    fun clearHistory() {
        viewModelScope.launch { repo.clearAll() }
    }
}
