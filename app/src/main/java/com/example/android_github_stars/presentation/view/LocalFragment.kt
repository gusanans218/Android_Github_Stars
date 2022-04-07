package com.example.android_github_stars.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android_github_stars.R
import com.example.android_github_stars.databinding.FragmentApiBinding
import com.example.android_github_stars.databinding.FragmentLocalBinding
import com.example.android_github_stars.presentation.placeholder.PlaceholderContent
import com.example.android_github_stars.presentation.viewmodel.LocalViewModel
import com.example.android_github_stars.presentation.viewmodel.SearchUserViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class LocalFragment : Fragment() {

    private val binding by lazy {
        FragmentLocalBinding.inflate(layoutInflater).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = localViewModel

        }
    }
    private val localViewModel: LocalViewModel by viewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
}