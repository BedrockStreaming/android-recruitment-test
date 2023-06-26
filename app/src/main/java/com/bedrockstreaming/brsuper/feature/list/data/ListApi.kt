package com.bedrockstreaming.brsuper.feature.list.data

import com.bedrockstreaming.brsuper.feature.list.data.model.RemoteHero
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.http.path

class ListApi(httpClient: HttpClient) {

    private val client = httpClient.config {
        defaultRequest {
            url("https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/")
        }
    }

    suspend fun getAll(): List<RemoteHero> {
        return client.get { url { path("all.json") } }.body()
    }

}
