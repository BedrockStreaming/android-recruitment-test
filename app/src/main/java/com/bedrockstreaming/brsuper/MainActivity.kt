package com.bedrockstreaming.brsuper

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.core.view.WindowCompat
import com.bedrockstreaming.brsuper.feature.list.presentation.ListScreen
import com.google.accompanist.themeadapter.material3.Mdc3Theme

class MainActivity : AppCompatActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            Mdc3Theme {
                val windowSizeClass = calculateWindowSizeClass(this@MainActivity)
                ListScreen()
            }
        }
    }
}
