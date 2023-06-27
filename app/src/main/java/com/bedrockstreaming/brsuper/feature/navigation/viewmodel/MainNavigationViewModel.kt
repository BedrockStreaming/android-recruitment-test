package com.bedrockstreaming.brsuper.feature.navigation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainNavigationViewModel : ViewModel() {

    sealed class Destination {
        object Home : Destination()
        data class Details(val id: String) : Destination()
    }

    private val _currentDestination = MutableStateFlow<Destination>(Destination.Home)
    val currentDestination = _currentDestination.asStateFlow()

    fun onNavigateUp() {
        viewModelScope.launch {
            _currentDestination.emit(Destination.Home)
        }
    }

    fun navigateToDetails(id: String) {
        viewModelScope.launch {
            _currentDestination.emit(Destination.Details(id = id))
        }
    }
}