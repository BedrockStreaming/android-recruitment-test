package com.bedrockstreaming.brsuper.component.hero.domain

import com.bedrockstreaming.brsuper.component.hero.domain.model.Biography

class GetHeroBiographyUseCase(
    private val heroRepository: HeroRepository
) {

    suspend operator fun invoke(id: String): Biography {
        return heroRepository.getHeroBiography(id)
    }
}