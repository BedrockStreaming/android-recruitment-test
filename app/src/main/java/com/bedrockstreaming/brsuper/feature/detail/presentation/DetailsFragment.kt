package com.bedrockstreaming.brsuper.feature.detail.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bedrockstreaming.brsuper.R
import org.koin.android.ext.android.inject

class DetailsFragment : Fragment() {

    companion object {
        fun newInstance(id: String): DetailsFragment {
            return DetailsFragment().apply {
                arguments = Bundle().apply {
                    putString("id", id)
                }
            }
        }
    }

    private val viewModel: DetailsViewModel by inject()

    private var viewHolder: ViewHolder? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val id = arguments?.getString("id")
            ?: error("ID is required to create DetailsFragment")

        viewModel.load(id)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_details, container, false)
            .also { view -> viewHolder = ViewHolder(view) }
    }

    class ViewHolder(rootView: View)
}
