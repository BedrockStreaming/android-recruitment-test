package com.bedrockstreaming.brsuper.feature.list.inject

import com.bedrockstreaming.brsuper.feature.list.api.ListApi
import com.bedrockstreaming.brsuper.feature.list.repository.ListRepositoryImpl
import com.bedrockstreaming.brsuper.feature.list.usecase.FilterHeroesUseCase
import com.bedrockstreaming.brsuper.feature.list.usecase.GetHeroListUseCase
import com.bedrockstreaming.brsuper.feature.list.repository.ListRepository
import com.bedrockstreaming.brsuper.feature.list.viewmodel.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ListModule = module {
    single { ListApi(get()) }
    single<ListRepository> { ListRepositoryImpl(get()) }
    single { GetHeroListUseCase(get()) }
    single { FilterHeroesUseCase() }
    viewModel { ListViewModel(get(), get()) }
}
