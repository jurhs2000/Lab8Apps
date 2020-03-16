package com.example.lab8apps.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.lab8apps.R
import com.example.lab8apps.databinding.UsersFragmentBinding

class UsersFragment : Fragment() {

    private lateinit var binding: UsersFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<UsersFragmentBinding>(inflater, R.layout.users_fragment, container, false)
        binding.goToRepos.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_usersFragment_to_reposFragment)
        }
        return binding.root
    }
}