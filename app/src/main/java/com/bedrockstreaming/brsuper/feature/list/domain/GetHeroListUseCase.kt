package com.bedrockstreaming.brsuper.feature.list.domain

import com.bedrockstreaming.brsuper.feature.list.domain.model.Hero

class GetHeroListUseCase(
    private val listRepository: ListRepository,
) {
    suspend operator fun invoke(): List<Hero> {
        return listRepository.getHeroList()
    }
}