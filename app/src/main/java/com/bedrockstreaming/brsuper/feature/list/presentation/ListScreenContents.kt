package com.bedrockstreaming.brsuper.feature.list.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bedrockstreaming.brsuper.PreviewMaterialTheme
import com.bedrockstreaming.brsuper.feature.component.hero.domain.model.Hero

@Composable
fun ListScreenContents(
    modifier: Modifier = Modifier,
    heroes: List<Hero>,
    insets: PaddingValues = PaddingValues(),
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = insets,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(
            items = heroes,
            key = { hero -> hero.id }
        ) { hero ->
            HeroListItem(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth(),
                hero = hero
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ListScreenContentsPreview() {
    PreviewMaterialTheme {
        ListScreenContents(
            heroes = listOf(
                Hero(
                    id = "1",
                    name = "A-Bomb",
                    imageUrl = ""
                ),
                Hero(
                    id = "2",
                    name = "Abe Sapien",
                    imageUrl = ""
                ),
                Hero(
                    id = "3",
                    name = "Abin Sur",
                    imageUrl = ""
                )
            )
        )
    }
}
