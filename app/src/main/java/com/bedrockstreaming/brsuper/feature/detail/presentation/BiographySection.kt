package com.bedrockstreaming.brsuper.feature.detail.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bedrockstreaming.brsuper.PreviewMaterialTheme
import com.bedrockstreaming.brsuper.feature.detail.domain.model.Biography

@Composable
fun BiographySection(
    modifier: Modifier = Modifier,
    label: String,
    value: String,
) {
    Column(modifier = modifier) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelMedium
        )
        Text(
            text = value.ifEmpty { "-" },
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
