package com.bedrockstreaming.brsuper.feature.navigation.inject

import com.bedrockstreaming.brsuper.feature.navigation.presentation.MainNavigationViewModel
import org.koin.dsl.module

val NavigationModule = module {
    single { MainNavigationViewModel() }
}
