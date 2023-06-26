package com.bedrockstreaming.brsuper.feature.list.presentation.legacy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bedrockstreaming.brsuper.databinding.ItemLegacyHeroBinding
import com.bedrockstreaming.brsuper.feature.list.domain.model.Hero

class LegacyListAdapter : ListAdapter<Hero, LegacyListAdapter.ViewHolder>(LegacyDiffCallback()) {

    private var _onClickListener: ((Hero) -> Unit)? = null

    fun setOnItemClickListener(listener: (Hero) -> Unit) {
        _onClickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            binding = ItemLegacyHeroBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            onClickListener = {
                _onClickListener?.invoke(it)
            }
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(hero = getItem(position))
    }

    class ViewHolder(
        private val binding: ItemLegacyHeroBinding,
        private val onClickListener: (Hero) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(hero: Hero) {
            binding.textViewListItemName.text = hero.name
            binding.imageViewListItemImage.load(hero.imageUrl) {
                crossfade(true)
            }
            binding.root.setOnClickListener {
                onClickListener(hero)
            }
        }
    }
}
