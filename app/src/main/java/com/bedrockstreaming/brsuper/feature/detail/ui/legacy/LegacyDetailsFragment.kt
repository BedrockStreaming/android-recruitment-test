package com.bedrockstreaming.brsuper.feature.detail.ui.legacy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bedrockstreaming.brsuper.databinding.FragmentLegacyDetailsBinding
import com.bedrockstreaming.brsuper.feature.detail.ui.DetailsViewModel
import com.bedrockstreaming.brsuper.feature.navigation.ui.legacy.navigator
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LegacyDetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by viewModel()

    private var binding: FragmentLegacyDetailsBinding? = null

    companion object {
        fun newInstance(id: String) = LegacyDetailsFragment().apply {
            arguments = Bundle().apply {
                putString("id", id)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requireActivity()
            .onBackPressedDispatcher
            .addCallback(this) {
                navigator.navigateUp()
            }

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
        return FragmentLegacyDetailsBinding.inflate(inflater, container, false)
            .also { binding -> this.binding = binding }
            .also { binding ->
                binding.topAppBarDetails.setNavigationOnClickListener {
                    navigator.navigateUp()
                }
            }
            .root
    }

}
