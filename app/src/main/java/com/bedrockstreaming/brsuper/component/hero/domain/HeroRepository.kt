package com.bedrockstreaming.brsuper.component.hero.domain

import com.bedrockstreaming.brsuper.component.hero.data.HeroApi
import com.bedrockstreaming.brsuper.component.hero.domain.model.Biography
import com.bedrockstreaming.brsuper.component.hero.domain.model.Hero

class HeroRepository(
    private val heroApi: HeroApi
) {
    suspend fun getHeroList(): List<Hero> {
        return heroApi.getAll().map { hero ->
            Hero(
                id = hero.id,
                name = hero.name,
                imageUrl = hero.images.medium
            )
        }
    }

    suspend fun getHeroBiography(id: String): Biography {
        return heroApi.getBiography(id).let {
            Biography(
                fullName = it.fullName,
                alterEgos = it.alterEgos,
                alignment = it.alignment
            )
        }
    }

}
