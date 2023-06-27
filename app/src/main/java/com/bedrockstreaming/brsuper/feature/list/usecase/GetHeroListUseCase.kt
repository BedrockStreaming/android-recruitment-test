package com.bedrockstreaming.brsuper.feature.list.usecase

import com.bedrockstreaming.brsuper.feature.list.model.Hero
import com.bedrockstreaming.brsuper.feature.list.repository.ListRepository

class GetHeroListUseCase(
    private val listRepository: ListRepository,
) {
    suspend operator fun invoke(): List<Hero> {
        return listRepository.getHeroList()
    }
}