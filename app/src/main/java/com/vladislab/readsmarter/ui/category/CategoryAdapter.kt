package com.vladislab.readsmarter.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vladislab.readsmarter.R
import com.vladislab.readsmarter.api.books.Book

class CategoryAdapter :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    private var dataList = emptyList<Book>()

    internal fun setDataList(dataList: List<Book>) {
        this.dataList = dataList
    }

    // Provide a direct reference to each of the views with data items

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView
        var author: TextView
        var image: ImageView
        var id: Int = 0
        var category: Int = 0

        init {
            title = itemView.findViewById(R.id.book_title)
            author = itemView.findViewById(R.id.book_author)
            image = itemView.findViewById(R.id.book_image)
        }

    }

    // Usually involves inflating a layout from XML and returning the holder
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        // Inflate the custom layout
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.book_card, parent, false)
        return ViewHolder(view)
    }

    // Involves populating data into the item through holder
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        var data = dataList[position]

        // Set item views based on your views and data model
        holder.title.text = data.name
        holder.author.text = data.author
        data.image?.let { holder.image.setImageResource(it) }
    }

    //  total count of items in the list
    override fun getItemCount() = dataList.size
}