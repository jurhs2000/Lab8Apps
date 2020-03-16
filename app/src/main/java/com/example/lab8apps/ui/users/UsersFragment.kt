package com.example.lab8apps.ui.users

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.bumptech.glide.Glide
import com.example.lab8apps.MainActivity
import com.example.lab8apps.R
import com.example.lab8apps.databinding.UsersFragmentBinding


class UsersFragment : Fragment() {

    private lateinit var binding: UsersFragmentBinding
    private val viewModel: UsersViewModel by lazy {
        ViewModelProviders.of(this).get(UsersViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<UsersFragmentBinding>(inflater, R.layout.users_fragment, container, false)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel
        binding.buttonSearch.setOnClickListener { view ->
            viewModel.getUser(binding.editTextUsername.text.toString());
        }
        var username = ""
        viewModel.name.observe(this.viewLifecycleOwner, Observer { name ->
            username = name
            binding.textViewUsername.text = "Nombre de usuario: " + name
        })
        viewModel.urlAvatar.observe(this.viewLifecycleOwner, Observer { urlAvatar ->
            Glide.with(this).load(urlAvatar).into(binding.imageViewAvatar)
        })
        viewModel.exists.observe(this.viewLifecycleOwner, Observer { exists ->
                binding.goToRepos.isEnabled = exists
        })
        binding.goToRepos.setOnClickListener { view ->
            MainActivity.user = username
            view.findNavController().navigate(R.id.action_usersFragment_to_reposFragment)
        }
        return binding.root
    }
}