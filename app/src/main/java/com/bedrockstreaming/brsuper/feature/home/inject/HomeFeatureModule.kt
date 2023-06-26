package com.bedrockstreaming.brsuper.feature.home.inject

import com.bedrockstreaming.brsuper.feature.home.presentation.MainNavigationViewModel
import org.koin.dsl.module

val HomeFeatureModule = module {
    single<MainNavigationViewModel> { MainNavigationViewModel() }
}
