package com.example.core.util

sealed class UiEvent{
    object Success: UiEvent()
    data class Navigate(val route : String) : UiEvent()
    data class ShowSnackbar(val message: UiText): UiEvent()
    object NavigateUp : UiEvent()

}
