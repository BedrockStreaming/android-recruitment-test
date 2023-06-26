package com.bedrockstreaming.brsuper.feature.navigation.presentation.legacy

import androidx.fragment.app.Fragment

val Fragment.navigator: LegacyNavigator
    get() = parentFragment as LegacyNavigator
