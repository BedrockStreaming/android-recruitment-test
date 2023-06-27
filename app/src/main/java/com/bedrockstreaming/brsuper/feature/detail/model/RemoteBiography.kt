package com.bedrockstreaming.brsuper.feature.detail.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteBiography(
    @SerialName("fullName")
    val fullName: String,
    @SerialName("alterEgos")
    val alterEgos: String,
    @SerialName("alignment")
    val alignment: String
)

fun RemoteBiography.toBiography(): Biography {
    return Biography(
        fullName,
        alterEgos,
        alignment
    )
}