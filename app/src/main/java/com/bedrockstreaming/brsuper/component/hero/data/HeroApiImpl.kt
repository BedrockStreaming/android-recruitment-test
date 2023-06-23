package com.bedrockstreaming.brsuper.component.hero.data

import com.bedrockstreaming.brsuper.component.hero.data.model.Hero
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.get
import io.ktor.http.path

class HeroApiImpl(
    httpClient: HttpClient,
) : HeroApi {

    private val client = httpClient.config {
        defaultRequest {
            url("https://cdn.jsdelivr.net/gh/akabab/superhero-api@0.3.0/api/")
        }
    }

    override suspend fun getAll(): List<Hero> {
        return client.get { url { path("all.json") } }.body()
    }
}
