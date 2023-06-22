package com.bedrockstreaming.brsuper.feature.component.hero.data

import com.bedrockstreaming.brsuper.feature.component.hero.data.model.Hero

class HeroApiImpl : HeroApi {

    override suspend fun getAll(): List<Hero> {
        return emptyList()
    }
}
