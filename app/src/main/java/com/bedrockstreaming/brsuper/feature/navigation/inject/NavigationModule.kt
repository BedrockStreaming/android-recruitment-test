package com.bedrockstreaming.brsuper.feature.navigation.inject

import com.bedrockstreaming.brsuper.feature.navigation.ui.MainNavigationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val NavigationModule = module {
    viewModel { MainNavigationViewModel() }
}
