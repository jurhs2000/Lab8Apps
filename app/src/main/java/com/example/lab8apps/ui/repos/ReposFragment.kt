package com.example.lab8apps.ui.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.lab8apps.R
import com.example.lab8apps.databinding.ReposFragmentBinding

class ReposFragment : Fragment() {

    private lateinit var binding: ReposFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<ReposFragmentBinding>(inflater, R.layout.repos_fragment, container, false)
        return binding.root
    }
}