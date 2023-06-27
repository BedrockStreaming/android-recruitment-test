package com.bedrockstreaming.brsuper.feature.list.usecase

import com.bedrockstreaming.brsuper.feature.list.model.Hero

class FilterHeroesUseCase {

    operator fun invoke(
        filter: String,
        heroes: List<Hero>,
    ): List<Hero> {
        return heroes.filter { hero ->
            hero.name.contains(
                filter,
                ignoreCase = true
            )
        }
    }
}
