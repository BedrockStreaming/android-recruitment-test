package com.bedrockstreaming.brsuper.feature.list.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bedrockstreaming.brsuper.component.hero.domain.GetHeroListUseCase
import com.bedrockstreaming.brsuper.component.hero.domain.model.Hero
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HeroListViewModel(
    private val getHeroList: GetHeroListUseCase,
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

            withContext(Dispatchers.Main) {
                _state.update { state ->
                    when (state) {
                        is State.Loading -> state
                        is State.Content -> state.copy(
                            filteredHeroes = state.allHeroes.filter { hero ->
                                hero.name.contains(
                                    filter,
                                    ignoreCase = true
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}
