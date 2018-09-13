package com.example.tainguyen.mvvm.presentation.listComic

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.tainguyen.mvvm.R
import com.example.tainguyen.mvvm.domain.models.Comic
import com.example.tainguyen.mvvm.utils.*
import kotlinx.android.synthetic.main.list_item_comic.view.*
import kotlin.properties.Delegates

class ComicAdapter(data: List<Comic> = emptyList(), val rxEventBus: RxEventBus) : RecyclerView.Adapter<ComicAdapterViewHolder>() {

    var data by Delegates.observable(data) { _, _, _ -> notifyDataSetChanged() }

    override fun onBindViewHolder(holder: ComicAdapterViewHolder, position: Int) = holder.bindData(data[position])

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicAdapterViewHolder = ComicAdapterViewHolder(parent.inflate(R.layout.list_item_comic), rxEventBus)

    override fun getItemCount(): Int = data.size
}

class ComicAdapterViewHolder(itemView: View, private val rxEventBus: RxEventBus) : RecyclerView.ViewHolder(itemView) {

    fun bindData(item: Comic) = with(itemView) {
        tvTitle.text = item.title
        tvPrice.text = item.prices.toString()
        if (!item.images.isEmpty()) {
            iv_thumbnail.loadImage(item.images[0])
        } else {
            iv_thumbnail.loadImage(item.thumbnail)
        }
        setOnClickListener { rxEventBus.publishWithLock(OnComicSelectedEvent(item)) }
    }
}

class OnComicSelectedEvent(val comic: Comic)