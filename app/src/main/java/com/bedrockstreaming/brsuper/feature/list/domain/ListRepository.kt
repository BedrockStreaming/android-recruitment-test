package com.bedrockstreaming.brsuper.feature.list.domain

import com.bedrockstreaming.brsuper.feature.list.domain.model.Hero

interface ListRepository {
    suspend fun getHeroList(): List<Hero>
}
