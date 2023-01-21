package com.vladislab.readsmarter.ui.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vladislab.readsmarter.api.books.Book
import com.vladislab.readsmarter.ui.categories.CategoriesAdapter
import com.vladislab.readsmarter.databinding.FragmentCategoriesBinding
import com.vladislab.readsmarter.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private lateinit var adapter: SearchAdapter
    private lateinit var recyclerView: RecyclerView

    private var dataList = mutableListOf<Book>()


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val searchViewModel: SearchViewModel by viewModels { SearchViewModel.Factory("Красная") }

        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        val root: View = binding.root
        if (container?.context !== null) {
            recyclerView = binding.recyclerView

            recyclerView.layoutManager = GridLayoutManager(container.context, 3)
            adapter = SearchAdapter()
            recyclerView.adapter = adapter

            searchViewModel.items.observe(viewLifecycleOwner) {
                it.forEach { item ->
                    dataList.add(item)
                }
            }
            adapter.setDataList(dataList)
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}