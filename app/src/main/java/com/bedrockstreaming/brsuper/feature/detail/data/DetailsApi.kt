package com.bedrockstreaming.brsuper.feature.detail.data

import com.bedrockstreaming.brsuper.feature.detail.data.model.RemoteBiography
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.http.path

class DetailsApi(httpClient: HttpClient) {

    private val client = httpClient.config {
        defaultRequest {
            url("https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/")
        }
    }

    suspend fun getBiography(id: String): RemoteBiography {
        return client.get { url { path("/biography/${id}.json") } }.body()
    }
}