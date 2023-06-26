package com.bedrockstreaming.brsuper.feature.detail.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.bedrockstreaming.brsuper.databinding.ContainerDetailsBinding
import com.bedrockstreaming.brsuper.feature.detail.presentation.legacy.LegacyDetailsFragment

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    id: String,
    onBackPress: (() -> Unit)? = null,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Details") },
                navigationIcon = {
                    if (onBackPress != null) {
                        IconButton(onClick = onBackPress) {
                            Icon(
                                Icons.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                }
            )
        }
    ) { insets ->
        Box(
            modifier = modifier
                .padding(insets)
                .padding(16.dp)
        ) {
            AndroidViewBinding(ContainerDetailsBinding::inflate) {
                fragmentContainerView
                    .getFragment<LegacyDetailsFragment>()
                    .loadHeroWithId(id)
            }
        }
    }
}
