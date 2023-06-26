package com.bedrockstreaming.brsuper.feature.list.data

import com.bedrockstreaming.brsuper.feature.list.data.model.toHero
import com.bedrockstreaming.brsuper.feature.list.domain.ListRepository
import com.bedrockstreaming.brsuper.feature.list.domain.model.Hero

class ListRepositoryImpl(private val listApi: ListApi) : ListRepository {

    override suspend fun getHeroList(): List<Hero> {
        return listApi.getAll().map { remoteHero ->
            remoteHero.toHero()
        }
    }
}