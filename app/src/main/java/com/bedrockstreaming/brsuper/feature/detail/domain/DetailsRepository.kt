package com.bedrockstreaming.brsuper.feature.detail.domain

import com.bedrockstreaming.brsuper.feature.detail.domain.model.Biography

interface DetailsRepository {

    suspend fun getHeroBiography(id: String): Biography

}