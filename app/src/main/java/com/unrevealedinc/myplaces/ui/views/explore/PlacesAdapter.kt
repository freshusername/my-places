package com.unrevealedinc.myplaces.ui.views.explore

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.unrevealedinc.myplaces.data.entities.Place
import com.unrevealedinc.myplaces.databinding.ItemPlaceBinding
import kotlinx.android.synthetic.main.fragment_place_details.view.*


class PlacesAdapter(private val listener: PlaceItemListener) : RecyclerView.Adapter<PlaceViewHolder>() {

    interface PlaceItemListener {
        fun onClickedPlace(placeId: Long)
    }
    private val items = ArrayList<Place>()

    fun setItems(items: ArrayList<Place>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val binding: ItemPlaceBinding = ItemPlaceBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PlaceViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) = holder.bind(items[position])
}

class PlaceViewHolder(
    private val itemBinding: ItemPlaceBinding,
    private val listener: PlacesAdapter.PlaceItemListener
) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var place: Place

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Place) {
        this.place = item
        itemBinding.name.text = item.name

        var placeIsOpen = "Open"
        if(!item.isOpen)
            placeIsOpen = "Closed"

        itemBinding.typeAndStatus.text = "${item.type} - $placeIsOpen"

        val uri = "https://maps.googleapis.com/maps/api/place/photo?maxwidth=200&photoreference=" + item.photoReference + "&key="
        val icon = item.icon

        Glide.with(itemBinding.root)
            .load(uri)
            .into(itemBinding.image)

        Glide.with(itemBinding.root)
            .load(icon)
            .into(itemBinding.icon)
    }

    override fun onClick(v: View?) {
        listener.onClickedPlace(place.id)
    }
}
