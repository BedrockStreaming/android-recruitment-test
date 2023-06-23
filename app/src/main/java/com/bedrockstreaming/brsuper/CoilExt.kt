package com.bedrockstreaming.brsuper

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalInspectionMode
import coil.request.ImageRequest

@Composable
fun ImageRequest.Builder.debugPlaceholder(@DrawableRes previewResId: Int) = apply {
    if (LocalInspectionMode.current) {
        placeholder(previewResId)
    }
}
