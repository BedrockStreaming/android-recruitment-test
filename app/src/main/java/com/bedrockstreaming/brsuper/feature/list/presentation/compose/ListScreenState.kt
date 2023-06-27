package com.bedrockstreaming.brsuper.feature.list.presentation.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.bedrockstreaming.brsuper.Loader
import com.bedrockstreaming.brsuper.feature.list.presentation.ListViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListScreenState(
    modifier: Modifier,
    viewModel: ListViewModel = koinViewModel(),
    listState: LazyListState = rememberLazyListState(),
    onItemClick: (String) -> Unit = {},
    insets: PaddingValues = PaddingValues(),
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.load()
    }

    when (val currentState = state) {
        is ListViewModel.State.Loading -> {
            Loader(
                modifier = modifier.padding(insets)
            )
        }

        is ListViewModel.State.Content -> {
            ListScreenContents(
                modifier = modifier,
                heroes = currentState.filteredHeroes,
                listState = listState,
                filter = currentState.filter,
                onFilterChange = viewModel::updateFilter,
                onItemClick = onItemClick,
                insets = insets
            )
        }
    }
}
