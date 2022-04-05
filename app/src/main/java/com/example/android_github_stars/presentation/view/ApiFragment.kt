package com.example.android_github_stars.presentation.view

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android_github_stars.databinding.FragmentApiBinding
import com.example.android_github_stars.databinding.FragmentApiListBinding
import com.example.android_github_stars.presentation.adapter.ApiRecyclerViewAdapter
import com.example.android_github_stars.presentation.viewmodel.ApiFragmentItemViewModel

class ApiFragment : Fragment() {

    private lateinit var viewModel: ApiFragmentItemViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentApiBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
            recyclerView.apply {
                setHasFixedSize(true)
                adapter = ApiRecyclerViewAdapter(arrayListOf())
                layoutManager = LinearLayoutManager(requireActivity())
            }
        }.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.onStart()
    }

}
