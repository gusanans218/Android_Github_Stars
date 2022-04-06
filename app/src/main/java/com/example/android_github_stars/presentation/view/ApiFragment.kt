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
import com.example.android_github_stars.presentation.adapter.ApiRecyclerViewAdapter
import com.example.android_github_stars.presentation.viewmodel.ApiFragmentItemViewModel
import com.example.android_github_stars.presentation.viewmodel.SearchUserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class ApiFragment : Fragment() {

    private val binding by lazy {
        FragmentApiBinding.inflate(layoutInflater).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = searchViewModel

        }
    }
    private val searchViewModel: SearchUserViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

}
