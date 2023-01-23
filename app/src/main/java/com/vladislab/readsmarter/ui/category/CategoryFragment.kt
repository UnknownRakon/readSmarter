package com.vladislab.readsmarter.ui.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vladislab.readsmarter.api.books.Book
import com.vladislab.readsmarter.databinding.FragmentCategoryBinding
import com.vladislab.readsmarter.ui.search.CategoryAdapter
import com.vladislab.readsmarter.ui.search.CategoryViewModel


class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private lateinit var adapter: CategoryAdapter
    private lateinit var recyclerView: RecyclerView

    private var dataList = mutableListOf<Book>()
    private var category: Int? = null

    private val binding get() = _binding!!

    companion object {
        fun newInstance(category: Int) =
            CategoryFragment().apply {
                arguments = Bundle().apply {
                    putInt("category", category)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        if (arguments?.getInt("category") != null) {
            category = arguments?.getInt("category")
        }
        val categoryViewModel: CategoryViewModel by viewModels {
            CategoryViewModel.Factory(
                category
            )
        }

        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        val root: View = binding.root
        if (container?.context !== null) {
            recyclerView = binding.recyclerView

            recyclerView.layoutManager = GridLayoutManager(container.context, 3)
            adapter = CategoryAdapter()
            recyclerView.adapter = adapter

            categoryViewModel.items.observe(viewLifecycleOwner) {
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