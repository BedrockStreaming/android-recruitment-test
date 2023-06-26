package com.bedrockstreaming.brsuper.feature.list.presentation.legacy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bedrockstreaming.brsuper.databinding.FragmentLegacyListBinding
import com.bedrockstreaming.brsuper.feature.list.presentation.HeroListViewModel
import com.bedrockstreaming.brsuper.feature.navigation.presentation.legacy.navigator
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LegacyListFragment : Fragment() {

    private val viewModel: HeroListViewModel by viewModel()

    private var binding: FragmentLegacyListBinding? = null

    companion object {
        fun newInstance() = LegacyListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            viewModel.state.collect { state ->
                when (state) {
                    is HeroListViewModel.State.Loading -> {
                        binding?.apply {
                            progressIndicatorList.isVisible = true
                            recyclerViewList.isVisible = false
                        }
                    }

                    is HeroListViewModel.State.Content -> {
                        binding?.apply {
                            (recyclerViewList.adapter as? LegacyListAdapter)?.submitList(state.filteredHeroes)

                            progressIndicatorList.isVisible = false
                            recyclerViewList.isVisible = true
                        }
                    }
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentLegacyListBinding.inflate(inflater, container, false)
            .also { binding -> this.binding = binding }
            .also { binding ->
                binding.topAppBarList.setOnClickListener {
                    binding.recyclerViewList.smoothScrollToPosition(0)
                }

                binding.recyclerViewList.apply {
                    layoutManager = LinearLayoutManager(context)
                    adapter = LegacyListAdapter().apply {
                        setOnItemClickListener { hero ->
                            navigator.navigateToDetails(hero.id)
                        }
                    }
                }

                ViewCompat.setOnApplyWindowInsetsListener(binding.recyclerViewList) { view, windowInsets ->
                    val insets = windowInsets.getInsets(WindowInsetsCompat.Type.navigationBars())
                    view.updatePadding(insets.left, insets.top, insets.right, insets.bottom)
                    WindowInsetsCompat.CONSUMED
                }
            }
            .root
    }

    override fun onResume() {
        super.onResume()
        viewModel.load()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
