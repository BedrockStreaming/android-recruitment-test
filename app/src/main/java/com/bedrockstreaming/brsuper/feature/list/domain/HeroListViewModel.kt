package com.bedrockstreaming.brsuper.feature.list.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bedrockstreaming.brsuper.feature.component.hero.domain.GetHeroListUseCase
import com.bedrockstreaming.brsuper.feature.component.hero.domain.model.Hero
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HeroListViewModel(
    private val getHeroList: GetHeroListUseCase,
) : ViewModel() {

    sealed class State {
        object Loading : State()
        data class Content(
            val heroes: List<Hero>,
        ) : State()
    }

    private val _state = MutableStateFlow<State>(State.Loading)
    val state = _state.asStateFlow()

    fun load() {
        viewModelScope.launch {
            _state.emit(State.Loading)
            _state.emit(
                State.Content(
                    heroes = getHeroList()
                )
            )
        }
    }
}
