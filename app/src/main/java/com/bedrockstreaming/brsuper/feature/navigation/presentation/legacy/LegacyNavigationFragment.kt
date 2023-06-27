package com.bedrockstreaming.brsuper.feature.navigation.presentation.legacy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bedrockstreaming.brsuper.R
import com.bedrockstreaming.brsuper.databinding.FragmentLegacyHomeBinding
import com.bedrockstreaming.brsuper.feature.detail.presentation.legacy.LegacyDetailsFragment
import com.bedrockstreaming.brsuper.feature.list.presentation.legacy.LegacyListFragment
import com.bedrockstreaming.brsuper.feature.navigation.presentation.MainNavigationViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LegacyNavigationFragment : Fragment(), LegacyNavigator {

    private val viewModel: MainNavigationViewModel by viewModel()

    private var binding: FragmentLegacyHomeBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return FragmentLegacyHomeBinding.inflate(inflater, container, false)
            .also { binding -> this.binding = binding }
            .root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            viewModel.currentDestination.collect { state ->
                when (state) {
                    is MainNavigationViewModel.Destination.Home -> {
                        childFragmentManager.beginTransaction()
                            .replace(
                                R.id.fragmentContainerView_homeFragment,
                                LegacyListFragment.newInstance()
                            )
                            .commit()
                    }

                    is MainNavigationViewModel.Destination.Details -> {
                        childFragmentManager.beginTransaction()
                            .replace(
                                R.id.fragmentContainerView_homeFragment,
                                LegacyDetailsFragment.newInstance(state.id)
                            )
                            .commit()
                    }
                }
            }
        }
    }

    override fun navigateUp() {
        viewModel.onNavigateUp()
    }

    override fun navigateToDetails(id: String) {
        viewModel.navigateToDetails(id)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
