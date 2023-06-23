package com.bedrockstreaming.brsuper.feature.list.presentation

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.bedrockstreaming.brsuper.feature.component.hero.domain.model.Hero

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
                model = hero.imageUrl,
                contentDescription = null
            )

            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.surface.copy(alpha = 0.5f),
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
@Composable
fun HeroListItemPreview() {
    HeroListItem(
        hero = Hero(
            id = "1",
            name = "A-Bomb",
            imageUrl = ""
        )
    )
}
