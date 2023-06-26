package com.bedrockstreaming.brsuper.feature.detail.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    id: String,
) {
    Box(modifier = modifier) {
        Text("Details screen for $id")
    }
}
