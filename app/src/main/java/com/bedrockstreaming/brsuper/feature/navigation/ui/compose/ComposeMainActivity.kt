package com.bedrockstreaming.brsuper.feature.navigation.ui.compose

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.core.view.WindowCompat
import com.google.accompanist.themeadapter.material3.Mdc3Theme

class ComposeMainActivity : AppCompatActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            Mdc3Theme {
                MainNavigation(
                    windowSizeClass = calculateWindowSizeClass(this@ComposeMainActivity)
                )
            }
        }
    }
}
