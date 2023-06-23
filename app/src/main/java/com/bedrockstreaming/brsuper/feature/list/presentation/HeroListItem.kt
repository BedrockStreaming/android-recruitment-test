package com.bedrockstreaming.brsuper.feature.list.presentation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.bedrockstreaming.brsuper.feature.component.hero.domain.model.Hero

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroListItem(
    modifier: Modifier = Modifier,
    hero: Hero,
    onClick: () -> Unit = {},
) {
    Card(
        modifier = modifier,
        onClick = onClick,
    ) {
        Row(modifier = modifier.padding(8.dp)) {
            Text(text = hero.name)
        }
    }
}
