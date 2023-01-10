package com.vladislab.readsmarter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    private var dataList = emptyList<String>()

    internal fun setDataList(dataList: List<String>) {
        this.dataList = dataList
    }

    // Provide a direct reference to each of the views with data items

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var id: Int = 0

        init {
            title = itemView.findViewById(R.id.category_card_title)
        }

    }

    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        // Inflate the custom layout
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.category_card, parent, false)
        return ViewHolder(view)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        // Get the data model based on position
        var data = dataList[position]

        // Set item views based on your views and data model
        holder.title.text = data
        holder.id = position
    }

    //  total count of items in the list
    override fun getItemCount() = dataList.size
}