package com.bedrockstreaming.brsuper.feature.component.hero.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Hero(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String,
    @SerialName("images")
    val images: Images,
)
