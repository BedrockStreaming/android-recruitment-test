package com.bedrockstreaming.brsuper.feature.detail.ui.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bedrockstreaming.brsuper.feature.common.Loader
import com.bedrockstreaming.brsuper.feature.detail.viewmodel.DetailsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailsScreenState(
    modifier: Modifier = Modifier,
    insets: PaddingValues = PaddingValues(),
    viewModel: DetailsViewModel = koinViewModel(),
    id: String,
) {
    val state by viewModel.state.collectAsState()

    LaunchedEffect(id) {
        viewModel.load(id)
    }

    when (val currentState = state) {
        is DetailsViewModel.State.Loading -> {
            Loader(
                modifier = modifier
            )
        }

        is DetailsViewModel.State.Content -> {
            DetailsScreenContents(
                modifier = modifier.padding(16.dp),
                biography = currentState.biography,
                insets = insets
            )
        }
    }
}
