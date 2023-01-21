package com.vladislab.readsmarter.ui.catalog

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.SearchView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.vladislab.readsmarter.addChildFragment
import com.vladislab.readsmarter.databinding.FragmentCatalogBinding
import com.vladislab.readsmarter.ui.categories.CategoriesFragment
import com.vladislab.readsmarter.ui.search.SearchFragment


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
            ViewModelProvider(this)[CatalogViewModel::class.java]

        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.booksSearchView.setOnQueryTextListener(search)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val childFragment = CategoriesFragment()
        val transaction = childFragmentManager.beginTransaction()
        transaction.add(binding.subFragmentCatalog.id, childFragment).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                Log.println(Log.DEBUG, "log", childFragmentManager.backStackEntryCount.toString())
                if (childFragmentManager.backStackEntryCount > 1) {
                    childFragmentManager.popBackStackImmediate()
                    if (!binding.booksSearchView.isIconified) {
                        binding.booksSearchView.isIconified = true;
                    }
                    Log.println(Log.DEBUG, "log", "back pressed")
                } else {
                    isEnabled = false
                    activity?.finish()
                }
            }
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val search: SearchView.OnQueryTextListener = object : SearchView.OnQueryTextListener {
        override fun onQueryTextSubmit(query: String): Boolean {
            binding.booksSearchView.layoutParams = LinearLayout.LayoutParams(
                binding.booksSearchView.layoutParams.width,
                binding.booksSearchView.layoutParams.height,
                0.92f
            )
            binding.sortButton.visibility = View.VISIBLE
            val childFragment = SearchFragment.newInstance(query)
            addChildFragment(childFragment, binding.subFragmentCatalog.id)
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
                val childFragment = CategoriesFragment()
                val transaction = childFragmentManager.beginTransaction()
                transaction.replace(binding.subFragmentCatalog.id, childFragment).commit()
            }
            return false
        }
    }
}