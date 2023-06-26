package com.bedrockstreaming.brsuper.feature.list.presentation.compose

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.bedrockstreaming.brsuper.PreviewMaterialTheme
import com.bedrockstreaming.brsuper.R
import com.bedrockstreaming.brsuper.debugPlaceholder
import com.bedrockstreaming.brsuper.feature.list.domain.model.Hero

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroListItem(
    modifier: Modifier = Modifier,
    hero: Hero,
    onClick: () -> Unit = {},
) {
    Card(
        modifier = modifier.height(64.dp),
        onClick = onClick,
    ) {
        Box {
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f / 3f)
                    .clip(MaterialTheme.shapes.medium),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(hero.imageUrl)
                    .crossfade(true)
                    .debugPlaceholder(R.drawable.item_preview_placeholder)
                    .build(),
                contentDescription = null
            )

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.7f),
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = hero.name,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HeroListItemPreview() {
    PreviewMaterialTheme {
        HeroListItem(
            hero = Hero(
                id = "1",
                name = "A-Bomb",
                imageUrl = ""
            )
        )
    }
}
