package com.bedrockstreaming.brsuper.feature.detail.presentation.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bedrockstreaming.brsuper.PreviewMaterialTheme
import com.bedrockstreaming.brsuper.feature.detail.domain.model.Biography

@Composable
fun DetailsScreenContents(
    modifier: Modifier = Modifier,
    biography: Biography,
    insets: PaddingValues = PaddingValues(),
) {
    Column(
        modifier = modifier.padding(insets),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        BiographySection(
            label = "Full Name",
            value = biography.fullName,
        )

        BiographySection(
            label = "Alter Egos",
            value = biography.alterEgos,
        )

        BiographySection(
            label = "Alignment",
            value = biography.alignment,
        )
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun DetailsScreenContentsPreview() {
    PreviewMaterialTheme {
        Surface {
            DetailsScreenContents(
                biography = Biography(
                    fullName = "Bruce Wayne",
                    alterEgos = "No alter egos found.",
                    alignment = "good"
                )
            )
        }
    }
}
