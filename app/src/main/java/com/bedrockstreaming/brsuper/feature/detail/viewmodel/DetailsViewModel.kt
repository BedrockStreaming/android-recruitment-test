package com.bedrockstreaming.brsuper.feature.detail.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bedrockstreaming.brsuper.feature.detail.model.Biography
import com.bedrockstreaming.brsuper.feature.detail.usecase.GetHeroBiographyUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val getHeroBiography: GetHeroBiographyUseCase
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
            _state.emit(
                State.Content(
                    biography = getHeroBiography(id)
                )
            )
        }
    }

}
