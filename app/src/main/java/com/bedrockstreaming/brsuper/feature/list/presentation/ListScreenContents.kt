package com.bedrockstreaming.brsuper.feature.list.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bedrockstreaming.brsuper.feature.component.hero.domain.model.Hero
import com.bedrockstreaming.brsuper.feature.list.domain.HeroListViewModel
import org.koin.compose.koinInject

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
@Composable
fun ListScreenContentsPreview() {
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
