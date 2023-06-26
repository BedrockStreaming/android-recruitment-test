package com.bedrockstreaming.brsuper.feature.detail.data

import com.bedrockstreaming.brsuper.feature.detail.data.model.toBiography
import com.bedrockstreaming.brsuper.feature.detail.domain.DetailsRepository
import com.bedrockstreaming.brsuper.feature.detail.domain.model.Biography

class DetailsRepositoryImpl(private val detailsApi: DetailsApi) : DetailsRepository {

    override suspend fun getHeroBiography(id: String): Biography {
        return detailsApi.getBiography(id).toBiography()
    }

}