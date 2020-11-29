package com.unrevealedinc.myplaces.ui.views.placeDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.rickandmorty.utils.autoCleared
import com.unrevealedinc.myplaces.data.entities.Place
import com.unrevealedinc.myplaces.databinding.FragmentPlaceDetailsBinding
import com.unrevealedinc.myplaces.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.content_place_details.view.*

@AndroidEntryPoint
class PlaceDetailFragment : Fragment() {

    private var binding: FragmentPlaceDetailsBinding by autoCleared()
    private val viewModel: PlaceDetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPlaceDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getInt("id")?.let { viewModel.start(it) }
        setupObservers()
    }

    private fun setupObservers() {
        viewModel.place.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    bindPlace(it.data!!)
                    binding.progressBar.visibility = View.GONE
                    binding.placeCoordlayout.visibility = View.VISIBLE
                }

                Resource.Status.ERROR ->
                    Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                    binding.placeCoordlayout.visibility = View.GONE
                }
            }
        })
    }

    //TODO: change props
    private fun bindPlace(place: Place) {
        binding.postContent.place_title.text = place.name
        binding.postContent.place_location.text = place.type
        binding.postContent.place_body.text = place.address
//        binding.postContent.text = place.type
//        Glide.with(binding.root)
//            .load(place.image)
//            .into(binding.image)
    }
}
