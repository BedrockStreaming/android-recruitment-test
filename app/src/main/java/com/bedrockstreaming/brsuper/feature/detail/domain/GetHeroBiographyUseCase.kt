package com.bedrockstreaming.brsuper.feature.detail.domain

import com.bedrockstreaming.brsuper.feature.detail.domain.model.Biography

class GetHeroBiographyUseCase(
    private val detailsRepository: DetailsRepository
) {

    suspend operator fun invoke(id: String): Biography {
        return detailsRepository.getHeroBiography(id)
    }
}