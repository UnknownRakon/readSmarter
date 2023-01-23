package com.vladislab.readsmarter.ui.categories

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vladislab.readsmarter.R
import com.vladislab.readsmarter.api.category.Category
import com.vladislab.readsmarter.databinding.CategoryCardBinding

class CategoriesAdapter(
    private var dataList: List<Category>,
    private var onItemClicked: ((category: Category) -> Unit)
) :
    RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Just to show as an example we took layout
        // 'MovieItem' as recyclerview items/views.
        val binding =
            CategoryCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // getting a movie from movieList &
        // passing in viewholder's bind function
        holder.bind(dataList[position])
    }

    inner class ViewHolder(val binding: CategoryCardBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(category: Category) = binding.apply {

            categoryCardTitle.text = category.name

            root.setOnClickListener {
                onItemClicked(category)
            }
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }
}