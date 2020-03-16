package com.example.lab8apps.ui.repos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab8apps.R
import com.example.lab8apps.databinding.ReposFragmentBinding

class ReposFragment : Fragment() {

    private lateinit var binding: ReposFragmentBinding
    private lateinit var viewModel: ReposViewModel

    lateinit var datos: ArrayList<String>
    lateinit var recycler: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(ReposViewModel::class.java)
        binding = DataBindingUtil.inflate<ReposFragmentBinding>(inflater, R.layout.repos_fragment, container, false)

        binding.viewModel = viewModel
        binding.setLifecycleOwner(this)

        recycler = binding.recycler

        var adapter = ReposAdapter(context!!)
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(context)

        viewModel.repos.observe(this.viewLifecycleOwner, Observer { repos ->
            repos?.let { adapter.setRepos(it) }
        })

        return binding.root
    }
}