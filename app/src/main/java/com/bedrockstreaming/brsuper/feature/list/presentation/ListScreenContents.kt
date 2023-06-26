package com.bedrockstreaming.brsuper.feature.list.presentation

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bedrockstreaming.brsuper.PreviewMaterialTheme
import com.bedrockstreaming.brsuper.component.hero.domain.model.Hero

@Composable
fun ListScreenContents(
    modifier: Modifier = Modifier,
    insets: PaddingValues = PaddingValues(),
    heroes: List<Hero>,
    listState: LazyListState = rememberLazyListState(),
    filter: String = "",
    onFilterChange: (String) -> Unit = {},
    onItemClick: (String) -> Unit = {},
) {
    LazyColumn(
        modifier = modifier,
        state = listState,
        contentPadding = insets,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        item(key = "search") {
            TextField(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .padding(bottom = 8.dp)
                    .fillMaxWidth(),
                singleLine = true,
                placeholder = { Text("Search for a hero…") },
                trailingIcon = {
                    if (filter.isNotEmpty()) {
                        IconButton(onClick = { onFilterChange("") }) {
                            Icon(
                                Icons.Rounded.Clear,
                                contentDescription = "Clear search filter"
                            )
                        }
                    }
                },
                value = filter,
                onValueChange = onFilterChange
            )
        }

        items(
            items = heroes,
            key = { hero -> hero.id }
        ) { hero ->
            HeroListItem(
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .fillMaxWidth(),
                onClick = { onItemClick(hero.id) },
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
