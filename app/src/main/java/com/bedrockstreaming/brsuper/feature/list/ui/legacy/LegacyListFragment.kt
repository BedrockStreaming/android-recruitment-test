package com.bedrockstreaming.brsuper.feature.list.ui.legacy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.core.view.updatePadding
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.bedrockstreaming.brsuper.databinding.FragmentLegacyListBinding
import com.bedrockstreaming.brsuper.feature.list.ui.ListViewModel
import com.bedrockstreaming.brsuper.feature.navigation.ui.legacy.navigator
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class LegacyListFragment : Fragment() {

    private val viewModel: ListViewModel by viewModel()

    private var binding: FragmentLegacyListBinding? = null

    companion object {
        fun newInstance() = LegacyListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            viewModel.state.collect { state ->
                when (state) {
                    is ListViewModel.State.Loading -> {
                        binding?.apply {
                            progressIndicatorList.isVisible = true
                            recyclerViewList.isVisible = false
                        }
                    }

                    is ListViewModel.State.Content -> {
                        binding?.apply {
                            (recyclerViewList.adapter as? LegacyListAdapter)?.submitList(state.filteredHeroes)

                            textInputLayoutListSearch.endIconMode =
                                if (state.filter.isNotBlank()) {
                                    TextInputLayout.END_ICON_CLEAR_TEXT
                                } else {
                                    TextInputLayout.END_ICON_NONE
                                }

                            if (textInputEditTextListSearch.text.toString() != state.filter) {
                                textInputEditTextListSearch.setText(state.filter)
                            }

                            progressIndicatorList.isVisible = false
                            recyclerViewList.isVisible = true
                        }
                    }
                }
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
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

                binding.textInputEditTextListSearch.addTextChangedListener {
                    viewModel.updateFilter(it.toString())
                }

                ViewCompat.setOnApplyWindowInsetsListener(binding.recyclerViewList) { view, windowInsets ->
                    val insets = windowInsets.getInsets(WindowInsetsCompat.Type.navigationBars())
                    view.updatePadding(
                        left = insets.left + view.paddingLeft,
                        top = insets.top + view.paddingTop,
                        right = insets.right + view.paddingRight,
                        bottom = insets.bottom + view.paddingBottom
                    )
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
