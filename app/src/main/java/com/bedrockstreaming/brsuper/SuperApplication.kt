package com.bedrockstreaming.brsuper

import android.app.Application
import com.bedrockstreaming.brsuper.feature.detail.inject.DetailsModule
import com.bedrockstreaming.brsuper.feature.list.inject.ListModule
import com.bedrockstreaming.brsuper.feature.navigation.inject.NavigationModule
import com.bedrockstreaming.brsuper.feature.common.inject.NetworkModule
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
                NetworkModule,
                NavigationModule,
                ListModule,
                DetailsModule
            )
        }
    }
}
