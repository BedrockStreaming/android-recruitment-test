package com.bedrockstreaming.brsuper.feature.list.presentation.legacy

import androidx.recyclerview.widget.DiffUtil
import com.bedrockstreaming.brsuper.feature.list.domain.model.Hero

class LegacyDiffCallback : DiffUtil.ItemCallback<Hero>() {
    override fun areItemsTheSame(oldItem: Hero, newItem: Hero): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Hero, newItem: Hero): Boolean {
        return oldItem == newItem
    }
}
