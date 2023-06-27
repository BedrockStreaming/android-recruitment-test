package com.bedrockstreaming.brsuper.feature.detail.repository

import com.bedrockstreaming.brsuper.feature.detail.model.Biography

interface DetailsRepository {

    suspend fun getHeroBiography(id: String): Biography

}