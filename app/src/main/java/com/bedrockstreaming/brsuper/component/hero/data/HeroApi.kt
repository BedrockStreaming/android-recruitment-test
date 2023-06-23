package com.bedrockstreaming.brsuper.component.hero.data

import com.bedrockstreaming.brsuper.component.hero.data.model.Hero

interface HeroApi {
    suspend fun getAll(): List<Hero>
}
