package com.vladislab.readsmarter.ui.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vladislab.readsmarter.api.category.Category
import com.vladislab.readsmarter.databinding.FragmentCategoriesBinding


class CategoriesFragment : Fragment() {

    private var _binding: FragmentCategoriesBinding? = null
    private lateinit var adapter: CategoriesAdapter
    private lateinit var recyclerView: RecyclerView

    private var dataList = mutableListOf<Category>()


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val categoriesViewModel =
            ViewModelProvider(this).get(CategoriesViewModel::class.java)

        _binding = FragmentCategoriesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        if (container?.context !== null) {
            categoriesViewModel.items.observe(viewLifecycleOwner) {
                it.forEach { item ->
                    dataList.add(item)
                }
            }
            recyclerView = binding.recyclerView

            recyclerView.layoutManager = GridLayoutManager(container.context, 2)
            adapter = CategoriesAdapter(dataList) { it: Category ->
                onItemClick(it.id)
            }
            recyclerView.adapter = adapter

        }


        return root
    }

    private fun onItemClick(categoryId: Int) {
        parentFragmentManager.setFragmentResult("category", bundleOf("value" to categoryId))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}