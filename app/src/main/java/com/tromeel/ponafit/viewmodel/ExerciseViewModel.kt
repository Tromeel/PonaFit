package com.tromeel.ponafit.viewmodel



import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tromeel.ponafit.model.ExerciseTrackingEntity
import com.tromeel.ponafit.repository.ExerciseRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ExerciseViewModel(private val repo: ExerciseRepository) : ViewModel() {

    val allTracking = repo.getAllTracking()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun trackExercise(name: String, duration: String) {
        viewModelScope.launch {
            repo.insertTracking(
                ExerciseTrackingEntity(exerciseName = name, duration = duration)
            )
        }
    }

    fun clearHistory() {
        viewModelScope.launch { repo.clearAll() }
    }
}
