package com.bedrockstreaming.brsuper.feature.detail.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bedrockstreaming.brsuper.databinding.FragmentDetailsBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by viewModel()

    private var binding: FragmentDetailsBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            viewModel.state.collect { state ->
                when (state) {
                    is DetailsViewModel.State.Loading -> {
                        binding?.apply {
                            groupLoading.isVisible = true
                            groupContent.isVisible = false
                        }
                    }

                    is DetailsViewModel.State.Content -> {
                        binding?.apply {
                            textViewFullName.text = state.biography.fullName.ifBlank { "-" }
                            textViewAlignment.text = state.biography.alignment.ifBlank { "-" }
                            textViewAlterEgos.text = state.biography.alterEgos.ifBlank { "-" }

                            groupLoading.isVisible = false
                            groupContent.isVisible = true
                        }
                    }
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return FragmentDetailsBinding.inflate(inflater, container, false)
            .also { binding -> this.binding = binding }
            .root
    }

    fun loadHeroWithId(id: String) {
        viewModel.load(id)
    }
}
