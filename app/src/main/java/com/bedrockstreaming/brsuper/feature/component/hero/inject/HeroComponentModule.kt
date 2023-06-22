package com.bedrockstreaming.brsuper.feature.component.hero.inject

import com.bedrockstreaming.brsuper.feature.component.hero.data.HeroApi
import com.bedrockstreaming.brsuper.feature.component.hero.data.HeroApiImpl
import org.koin.dsl.module

val HeroComponentModule = module {
    single<HeroApi> { HeroApiImpl() }
}
