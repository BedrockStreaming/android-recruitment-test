@file:OptIn(ExperimentalMaterial3Api::class)

package com.bedrockstreaming.brsuper.feature.list.presentation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ListScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Heroes") })
        }
    ) { insets ->
        ListScreenState(
            modifier = modifier,
            insets = insets
        )
    }
}
