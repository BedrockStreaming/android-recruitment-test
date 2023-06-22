package com.bedrockstreaming.brsuper.feature.component.hero.data

import com.bedrockstreaming.brsuper.feature.component.hero.data.model.Hero

interface HeroApi {
    suspend fun getAll(): List<Hero>
}
