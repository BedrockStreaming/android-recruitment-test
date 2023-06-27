package com.bedrockstreaming.brsuper.feature.list.repository

import com.bedrockstreaming.brsuper.feature.list.model.Hero

interface ListRepository {
    suspend fun getHeroList(): List<Hero>
}
