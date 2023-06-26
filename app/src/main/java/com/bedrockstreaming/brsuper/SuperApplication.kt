package com.bedrockstreaming.brsuper

import android.app.Application
import com.bedrockstreaming.brsuper.component.hero.inject.HeroComponentModule
import com.bedrockstreaming.brsuper.feature.detail.inject.HeroDetailsModule
import com.bedrockstreaming.brsuper.feature.home.inject.HomeFeatureModule
import com.bedrockstreaming.brsuper.feature.list.inject.HeroListFeatureModule
import com.google.android.material.color.DynamicColors
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class SuperApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)

        startKoin {
            androidLogger()
            androidContext(this@SuperApplication)
            modules(
                HomeFeatureModule,
                HeroComponentModule,
                HeroListFeatureModule,
                HeroDetailsModule,
            )
        }
    }
}
