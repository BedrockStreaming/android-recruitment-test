package com.bedrockstreaming.brsuper.feature.component.hero.inject

import com.bedrockstreaming.brsuper.feature.component.hero.data.HeroApi
import com.bedrockstreaming.brsuper.feature.component.hero.data.HeroApiImpl
import com.bedrockstreaming.brsuper.feature.component.hero.domain.GetHeroListUseCase
import com.bedrockstreaming.brsuper.feature.component.hero.domain.HeroRepository
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.ANDROID
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val HeroComponentModule = module {
    single {
        HttpClient(CIO) {
            expectSuccess = true

            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                    }
                )
            }

            install(Logging) {
                logger = Logger.ANDROID
                level = LogLevel.HEADERS
            }
        }
    }

    single<HeroApi> { HeroApiImpl(get()) }
    single { HeroRepository(get()) }
    single { GetHeroListUseCase(get()) }
}
