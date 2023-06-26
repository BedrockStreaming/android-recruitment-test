package com.bedrockstreaming.brsuper.feature.detail.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bedrockstreaming.brsuper.databinding.FragmentDetailsBinding
import org.koin.android.ext.android.inject

class DetailsFragment : Fragment() {

    private val viewModel: DetailsViewModel by inject()

    private var binding: FragmentDetailsBinding? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return FragmentDetailsBinding.inflate(inflater, container, false).also { binding ->
            this.binding = binding
        }.root
    }

    fun loadHeroWithId(id: String) {
        viewModel.load(id)
    }
}
