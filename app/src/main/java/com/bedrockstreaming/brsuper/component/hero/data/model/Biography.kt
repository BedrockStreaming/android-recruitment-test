package com.bedrockstreaming.brsuper.component.hero.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Biography(
    @SerialName("fullName")
    val fullName: String,
    @SerialName("alterEgos")
    val alterEgos: String,
    @SerialName("alignment")
    val alignment: String
)