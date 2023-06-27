package com.bedrockstreaming.brsuper.feature.detail.inject

import com.bedrockstreaming.brsuper.feature.detail.api.DetailsApi
import com.bedrockstreaming.brsuper.feature.detail.repository.DetailsRepositoryImpl
import com.bedrockstreaming.brsuper.feature.detail.repository.DetailsRepository
import com.bedrockstreaming.brsuper.feature.detail.usecase.GetHeroBiographyUseCase
import com.bedrockstreaming.brsuper.feature.detail.viewmodel.DetailsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val DetailsModule = module {
    single { DetailsApi(get()) }
    single<DetailsRepository> { DetailsRepositoryImpl(get()) }
    single { GetHeroBiographyUseCase(get()) }
    viewModel { DetailsViewModel(get()) }
}
