@file:OptIn(ExperimentalMaterial3Api::class)

package com.bedrockstreaming.brsuper.feature.list.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
) {
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.clickable {
                    scope.launch {
                        listState.animateScrollToItem(index = 0)
                    }
                },
                title = { Text("Heroes") }
            )
        }
    ) { insets ->
        ListScreenState(
            modifier = modifier,
            listState = listState,
            insets = insets
        )
    }
}
