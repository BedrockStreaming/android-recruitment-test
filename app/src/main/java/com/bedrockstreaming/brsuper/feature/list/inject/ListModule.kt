package com.bedrockstreaming.brsuper.feature.list.inject

import com.bedrockstreaming.brsuper.feature.list.data.ListApi
import com.bedrockstreaming.brsuper.feature.list.data.ListRepositoryImpl
import com.bedrockstreaming.brsuper.feature.list.domain.GetHeroListUseCase
import com.bedrockstreaming.brsuper.feature.list.domain.HeroListViewModel
import com.bedrockstreaming.brsuper.feature.list.domain.ListRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val ListModule = module {
    single { ListApi(get()) }
    single<ListRepository> { ListRepositoryImpl(get()) }
    single { GetHeroListUseCase(get()) }
    viewModel { HeroListViewModel(get()) }
}
