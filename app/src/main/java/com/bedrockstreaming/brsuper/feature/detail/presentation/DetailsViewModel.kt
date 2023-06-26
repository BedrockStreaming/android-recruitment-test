package com.bedrockstreaming.brsuper.feature.detail.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bedrockstreaming.brsuper.component.hero.domain.GetHeroBiographyUseCase
import com.bedrockstreaming.brsuper.component.hero.domain.model.Biography
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsViewModel(
    private val getHeroBiography: GetHeroBiographyUseCase,
) : ViewModel() {

    sealed class State {
        object Loading : State()
        data class Content(val biography: Biography) : State()
    }

    private val _state = MutableStateFlow<State>(State.Loading)
    val state = _state.asStateFlow()

    fun load(id: String) {
        viewModelScope.launch {
            _state.emit(State.Loading)
            withContext(Dispatchers.Main) {
                heavyOperation()
                _state.emit(
                    State.Content(
                        biography = getHeroBiography(id)
                    )
                )
            }
        }
    }

    private suspend fun heavyOperation() {
        delay(2000L)
    }
}
