package com.vladislab.readsmarter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter(var context: Context) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    private var dataList = emptyList<String>()

    internal fun setDataList(dataList: List<String>) {
        this.dataList = dataList
    }

    // Provide a direct reference to each of the views with data items

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView

        init {
            title = itemView.findViewById(R.id.category_card_title)
        }

    }

    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoriesAdapter.ViewHolder {

        // Inflate the custom layout
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.category_card, parent, false)
        return ViewHolder(view)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: CategoriesAdapter.ViewHolder, position: Int) {

        // Get the data model based on position
        var data = dataList[position]

        // Set item views based on your views and data model
        holder.title.text = data
    }

    //  total count of items in the list
    override fun getItemCount() = dataList.size
}