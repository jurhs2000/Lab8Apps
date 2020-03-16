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
import com.bumptech.glide.Glide
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
        viewModel.name.observe(this.viewLifecycleOwner, Observer { name ->
            binding.textViewUsername.text = name
        })
        viewModel.urlAvatar.observe(this.viewLifecycleOwner, Observer { urlAvatar ->
            Glide.with(this).load(urlAvatar).into(binding.imageViewAvatar)
        })
        binding.goToRepos.setOnClickListener { view ->
            if (true) {
                //view.findNavController().navigate(R.id.action_usersFragment_to_reposFragment)
            } else {

            }
        }
        return binding.root
    }
}