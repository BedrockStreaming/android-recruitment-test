package com.bedrockstreaming.brsuper

import android.app.Application
import com.google.android.material.color.DynamicColors

class SuperApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}
