package com.bedrockstreaming.brsuper.feature.detail.repository

import com.bedrockstreaming.brsuper.feature.detail.api.DetailsApi
import com.bedrockstreaming.brsuper.feature.detail.model.toBiography
import com.bedrockstreaming.brsuper.feature.detail.model.Biography

class DetailsRepositoryImpl(private val detailsApi: DetailsApi) : DetailsRepository {

    override suspend fun getHeroBiography(id: String): Biography {
        return detailsApi.getBiography(id).toBiography()
    }

}