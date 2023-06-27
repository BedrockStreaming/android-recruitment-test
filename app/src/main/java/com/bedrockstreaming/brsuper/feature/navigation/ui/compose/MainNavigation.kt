package com.bedrockstreaming.brsuper.feature.navigation.ui.compose

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Crossfade
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.bedrockstreaming.brsuper.feature.common.Empty
import com.bedrockstreaming.brsuper.feature.detail.ui.compose.DetailsScreen
import com.bedrockstreaming.brsuper.feature.list.ui.compose.ListScreen
import com.bedrockstreaming.brsuper.feature.navigation.viewmodel.MainNavigationViewModel
import com.microsoft.device.dualscreen.twopanelayout.TwoPaneLayout
import org.koin.androidx.compose.koinViewModel

@Composable
fun MainNavigation(
    modifier: Modifier = Modifier,
    windowSizeClass: WindowSizeClass,
    viewModel: MainNavigationViewModel = koinViewModel(),
) {
    val destination by viewModel.currentDestination.collectAsState()
    when (windowSizeClass.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            Crossfade(
                modifier = modifier,
                targetState = destination,
                label = "main nav"
            ) { currentDestination ->
                when (currentDestination) {
                    is MainNavigationViewModel.Destination.Home -> {
                        ListScreen(
                            onItemClick = viewModel::navigateToDetails
                        )
                    }

                    is MainNavigationViewModel.Destination.Details -> {
                        BackHandler {
                            viewModel.onNavigateUp()
                        }

                        DetailsScreen(
                            id = currentDestination.id,
                            onBackPress = viewModel::onNavigateUp
                        )
                    }
                }
            }
        }

        WindowWidthSizeClass.Medium,
        WindowWidthSizeClass.Expanded,
        -> {
            TwoPaneLayout(
                modifier = modifier,
                pane1 = {
                    ListScreen(
                        onItemClick = viewModel::navigateToDetails
                    )
                },
                pane2 = {
                    when (val currentDestination = destination) {
                        is MainNavigationViewModel.Destination.Home -> {
                            Empty()
                        }

                        is MainNavigationViewModel.Destination.Details -> {
                            DetailsScreen(
                                id = currentDestination.id
                            )
                        }
                    }
                },
            )
        }
    }
}
