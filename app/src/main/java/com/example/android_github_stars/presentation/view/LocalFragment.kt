package com.example.android_github_stars.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android_github_stars.databinding.FragmentLocalBinding
import com.example.android_github_stars.presentation.viewmodel.LocalViewModel
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