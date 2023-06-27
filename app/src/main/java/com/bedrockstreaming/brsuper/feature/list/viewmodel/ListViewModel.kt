package com.bedrockstreaming.brsuper.feature.list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bedrockstreaming.brsuper.feature.list.usecase.FilterHeroesUseCase
import com.bedrockstreaming.brsuper.feature.list.usecase.GetHeroListUseCase
import com.bedrockstreaming.brsuper.feature.list.model.Hero
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ListViewModel(
    private val getHeroList: GetHeroListUseCase,
    private val filterHeroes: FilterHeroesUseCase,
) : ViewModel() {

    sealed class State {
        object Loading : State()
        data class Content(
            val allHeroes: List<Hero>,
            val filter: String = "",
            val filteredHeroes: List<Hero> = allHeroes,
        ) : State()
    }

    private val _state = MutableStateFlow<State>(State.Loading)
    val state = _state.asStateFlow()

    fun load() {
        viewModelScope.launch {
            _state.emit(State.Loading)
            _state.emit(
                State.Content(
                    allHeroes = getHeroList(),
                )
            )
        }
    }

    fun updateFilter(filter: String) {
        viewModelScope.launch {
            _state.update { state ->
                when (state) {
                    is State.Loading -> state
                    is State.Content -> state.copy(filter = filter)
                }
            }

            _state.update { state ->
                when (state) {
                    is State.Loading -> state
                    is State.Content -> state.copy(
                        filteredHeroes = filterHeroes(
                            filter = filter,
                            heroes = state.allHeroes
                        )
                    )
                }
            }
        }
    }
}
