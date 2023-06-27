package com.bedrockstreaming.brsuper.feature.list.repository

import com.bedrockstreaming.brsuper.feature.list.api.ListApi
import com.bedrockstreaming.brsuper.feature.list.model.toHero
import com.bedrockstreaming.brsuper.feature.list.model.Hero

class ListRepositoryImpl(private val listApi: ListApi) : ListRepository {

    override suspend fun getHeroList(): List<Hero> {
        return listApi.getAll().map { remoteHero ->
            remoteHero.toHero()
        }
    }
}