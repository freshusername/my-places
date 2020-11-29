package com.unrevealedinc.myplaces.ui.views.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rickandmorty.utils.autoCleared
import com.unrevealedinc.myplaces.R
import com.unrevealedinc.myplaces.databinding.FragmentExploreBinding
import com.unrevealedinc.myplaces.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ExploreFragment : Fragment(), PlacesAdapter.PlaceItemListener {

    private var binding: FragmentExploreBinding by autoCleared()
    private val viewModel: PlacesViewModel by viewModels()
    private lateinit var adapter: PlacesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        setupObservers()
    }

    private fun setupRecyclerView() {
        adapter = PlacesAdapter(this)
        binding.placesRv.layoutManager = LinearLayoutManager(requireContext())
        binding.placesRv.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.places.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    if (!it.data.isNullOrEmpty()) adapter.setItems(ArrayList(it.data))
                }
                Resource.Status.ERROR ->
                    Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    binding.progressBar.visibility = View.VISIBLE
            }
        })
    }

    override fun onClickedPlace(placeId: Long) {
        findNavController().navigate(
            R.id.action_exploreFragment_to_placeDetailFragment,
            bundleOf("id" to placeId)
        )
    }
}
