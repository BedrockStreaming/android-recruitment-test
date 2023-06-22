package com.bedrockstreaming.brsuper.feature.component.hero.domain

import com.bedrockstreaming.brsuper.feature.component.hero.domain.model.Hero

class GetHeroListUseCase(
    private val heroRepository: HeroRepository,
) {
    suspend operator fun invoke(): List<Hero> {
        return heroRepository.getHeroList()
    }
}