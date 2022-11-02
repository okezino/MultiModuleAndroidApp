package com.example.onboarding_presentation.nutrientgoal

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.preferences.Preferences
import com.example.core.domain.usecase.FilterOutDigit
import com.example.core.navigation.Route
import com.example.core.util.UiEvent
import com.example.onboarding_domain.use_case.ValidateNutrients
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class NutrientGoalViewModel @Inject constructor(
    private val preferences: Preferences,
    private val filterOutDigit: FilterOutDigit,
    private val validateNutrients: ValidateNutrients
) : ViewModel() {

    var state by mutableStateOf(NutrientGoalState())
        private set


    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: NutrientGoalEvent) {
        when (event) {
            is NutrientGoalEvent.OnCarbRatioEnter -> {
                state = state.copy(
                    cardsRatio = filterOutDigit(event.ratio)
                )
            }

            is NutrientGoalEvent.OnProteinRatioEnter -> {
                state = state.copy(
                    proteinRatio = filterOutDigit(event.ratio)
                )
            }

            is NutrientGoalEvent.OnFatRatioEnter -> {
                state = state.copy(
                    fatRatio = filterOutDigit(event.ratio)
                )
            }
            else -> {
                val result = validateNutrients(
                    state.cardsRatio, state.proteinRatio, state.fatRatio
                )

                when(result){

                    is ValidateNutrients.Result.Success -> {
                        preferences.saveCarbRatio(result.card)
                        preferences.saveProteinRatio(result.protein)
                        preferences.saveFatRatio(result.fat)
                        viewModelScope.launch{
                            _uiEvent.send(UiEvent.Navigate(Route.TRACKER_OVERVIEW))
                        }
                    }
                    is ValidateNutrients.Result.Error -> {
                        viewModelScope.launch{
                            _uiEvent.send(UiEvent.ShowSnackbar(result.message))
                        }
                    }

                }

            }
        }
    }


}