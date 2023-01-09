package com.vladislab.readsmarter.ui.catalog

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
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
}