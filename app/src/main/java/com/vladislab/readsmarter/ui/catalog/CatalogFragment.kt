package com.vladislab.readsmarter.ui.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.vladislab.readsmarter.addChildFragment
import com.vladislab.readsmarter.databinding.FragmentCatalogBinding
import com.vladislab.readsmarter.ui.categories.CategoriesFragment


class CatalogFragment : Fragment() {

    private var _binding: FragmentCatalogBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val catalogViewModel =
            ViewModelProvider(this).get(CatalogViewModel::class.java)

        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.booksSearchView.setOnQueryTextListener(search)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val childFragment = CategoriesFragment()
        addChildFragment(childFragment, binding.subFragmentCatalog.id)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val search: SearchView.OnQueryTextListener = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String?): Boolean {
            binding.booksSearchView.layoutParams = LinearLayout.LayoutParams(
                binding.booksSearchView.layoutParams.width,
                binding.booksSearchView.layoutParams.height,
                0.92f
            )
            binding.sortButton.visibility = View.VISIBLE
            return false
        }

        override fun onQueryTextChange(newText: String?): Boolean {
            if (newText === null || newText.isEmpty()) {
                binding.booksSearchView.layoutParams = LinearLayout.LayoutParams(
                    binding.booksSearchView.layoutParams.width,
                    binding.booksSearchView.layoutParams.height,
                    1f
                )
                binding.sortButton.visibility = View.GONE
            }
            return false
        }
    }
}