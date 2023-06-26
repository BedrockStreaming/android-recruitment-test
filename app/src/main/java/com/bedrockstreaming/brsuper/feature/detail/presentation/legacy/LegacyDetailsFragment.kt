package com.bedrockstreaming.brsuper.feature.detail.presentation.legacy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bedrockstreaming.brsuper.databinding.FragmentDetailsBinding
import com.bedrockstreaming.brsuper.feature.detail.presentation.DetailsViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LegacyDetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by viewModel()

    private var binding: FragmentDetailsBinding? = null

    companion object {
        fun newInstance(id: String) = LegacyDetailsFragment().apply {
            arguments = Bundle().apply {
                putString("id", id)
            }
        }
    }

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

        if (savedInstanceState == null) {
            arguments?.getString("id")?.let { id ->
                viewModel.load(id)
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
