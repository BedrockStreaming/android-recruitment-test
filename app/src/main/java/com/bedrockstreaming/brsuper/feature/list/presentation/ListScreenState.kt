package com.bedrockstreaming.brsuper.feature.list.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.bedrockstreaming.brsuper.feature.list.domain.HeroListViewModel
import org.koin.compose.koinInject

@Composable
fun ListScreenState(
    modifier: Modifier,
    viewModel: HeroListViewModel = koinInject(),
    insets: PaddingValues = PaddingValues(),
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.load()
    }

    when (val currentState = state) {
        is HeroListViewModel.State.Loading -> {
            Loader(
                modifier = modifier.padding(insets)
            )
        }

        is HeroListViewModel.State.Content -> {
            ListScreenContents(
                heroes = currentState.heroes,
                insets = insets
            )
        }
    }
}
