package com.bedrockstreaming.brsuper.feature.list.inject

import com.bedrockstreaming.brsuper.feature.list.domain.HeroListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val HeroListFeatureModule = module {
    viewModel { HeroListViewModel(get()) }
}
