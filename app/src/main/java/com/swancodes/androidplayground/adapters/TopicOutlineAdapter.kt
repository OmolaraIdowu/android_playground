package com.swancodes.androidplayground.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.swancodes.androidplayground.R
import com.swancodes.androidplayground.model.Topic

class TopicOutlineAdapter (
    private val dataset: List<Topic>, private val onTopicItemClicked: (Topic) -> Unit,
) : RecyclerView.Adapter<TopicOutlineAdapter.TopicOutlineViewHolder>() {

    class TopicOutlineViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val button: TextView = view.findViewById(R.id.topic_button)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicOutlineViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return TopicOutlineViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: TopicOutlineViewHolder, position: Int) {
        val item = dataset[position]
        holder.button.text = item.name
        holder.button.setOnClickListener {
            onTopicItemClicked(item)
        }
    }

    override fun getItemCount() = dataset.size
}