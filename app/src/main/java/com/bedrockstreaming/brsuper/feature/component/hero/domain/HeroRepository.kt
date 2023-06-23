package com.bedrockstreaming.brsuper.feature.component.hero.domain

import com.bedrockstreaming.brsuper.feature.component.hero.data.HeroApi
import com.bedrockstreaming.brsuper.feature.component.hero.domain.model.Hero

class HeroRepository(
    private val heroApi: HeroApi,
) {
    suspend fun getHeroList(): List<Hero> {
        return heroApi.getAll().map { hero ->
            Hero(
                id = hero.id,
                name = hero.name,
                imageUrl = hero.images.small
            )
        }
    }
}
