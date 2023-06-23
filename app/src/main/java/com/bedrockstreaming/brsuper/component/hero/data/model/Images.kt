package com.bedrockstreaming.brsuper.component.hero.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Images(
    @SerialName("xs")
    val thumbnail: String,
    @SerialName("sm")
    val small: String,
    @SerialName("md")
    val medium: String,
    @SerialName("lg")
    val large: String,
)
