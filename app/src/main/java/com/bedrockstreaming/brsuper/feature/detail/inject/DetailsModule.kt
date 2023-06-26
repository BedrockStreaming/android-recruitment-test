package com.bedrockstreaming.brsuper.feature.detail.inject

import com.bedrockstreaming.brsuper.feature.detail.data.DetailsApi
import com.bedrockstreaming.brsuper.feature.detail.data.DetailsRepositoryImpl
import com.bedrockstreaming.brsuper.feature.detail.domain.DetailsRepository
import com.bedrockstreaming.brsuper.feature.detail.domain.GetHeroBiographyUseCase
import com.bedrockstreaming.brsuper.feature.detail.presentation.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val DetailsModule = module {
    single { DetailsApi(get()) }
    single<DetailsRepository> { DetailsRepositoryImpl(get()) }
    single { GetHeroBiographyUseCase(get()) }
    viewModel { DetailsViewModel(get()) }
}
