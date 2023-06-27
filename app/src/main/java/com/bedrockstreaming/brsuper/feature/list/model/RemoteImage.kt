package com.bedrockstreaming.brsuper.feature.list.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteImage(
    @SerialName("xs")
    val thumbnail: String,
    @SerialName("sm")
    val small: String,
    @SerialName("md")
    val medium: String,
    @SerialName("lg")
    val large: String
)