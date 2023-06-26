package com.bedrockstreaming.brsuper.feature.detail.inject

import com.bedrockstreaming.brsuper.feature.detail.presentation.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val HeroDetailsModule = module {
    viewModel { DetailsViewModel() }
}