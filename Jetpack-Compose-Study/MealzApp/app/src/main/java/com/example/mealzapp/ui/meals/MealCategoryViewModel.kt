package com.example.mealzapp.ui.meals

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealzapp.model.MealsRepository
import com.example.mealzapp.model.response.MealResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MealCategoryViewModel (
    private val repository: MealsRepository = MealsRepository.getInstance()
) : ViewModel() {

    // Job can be used to cancel coroutines, handle to track wait time as well, used in coroutine scope
    // Dispatcher, Main -> UI (less ideal), Default -> CPU, IO -> networking or file access

    val mealsState: MutableState<List<MealResponse>> = mutableStateOf(emptyList<MealResponse>())

    private val mealsJob = Job()
    private val scope = CoroutineScope(mealsJob + Dispatchers.IO)

    init {
        scope.launch {
            val meals = getMeals()
            mealsState.value = meals
        }

        // Note: using viewModelScope, you don't have to worry about onCleared
//        viewModelScope.launch(Dispatchers.IO) {
//            val meals = getMeals()
//            mealsState.value = meals
//        }
    }

    // When viewmodel is destroyed
    override fun onCleared() {
        super.onCleared()
        mealsJob.cancel()
    }

    suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }
}