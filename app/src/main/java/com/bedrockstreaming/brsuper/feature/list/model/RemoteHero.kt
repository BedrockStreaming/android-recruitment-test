package com.bedrockstreaming.brsuper.feature.list.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteHero(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("images")
    val images: RemoteImage
)

fun RemoteHero.toHero(): Hero {
    return Hero(
        id = id,
        name = name,
        imageUrl = images.medium
    )
}