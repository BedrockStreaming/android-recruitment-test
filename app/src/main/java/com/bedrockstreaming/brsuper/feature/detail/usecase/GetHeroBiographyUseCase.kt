package com.bedrockstreaming.brsuper.feature.detail.usecase

import com.bedrockstreaming.brsuper.feature.detail.model.Biography
import com.bedrockstreaming.brsuper.feature.detail.repository.DetailsRepository

class GetHeroBiographyUseCase(
    private val detailsRepository: DetailsRepository
) {

    suspend operator fun invoke(id: String): Biography {
        return detailsRepository.getHeroBiography(id)
    }
}