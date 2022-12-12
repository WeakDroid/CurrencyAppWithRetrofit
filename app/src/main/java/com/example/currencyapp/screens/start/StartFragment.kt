package com.example.currencyapp.screens.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyapp.R
import com.example.currencyapp.databinding.FragmentStartBinding
import kotlinx.android.synthetic.main.fragment_start.view.*

class StartFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StartAdapter
    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStartBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(this)[StartViewModel::class.java]

        val v = inflater.inflate(R.layout.fragment_start, container, false)
        recyclerView = v.rv_start
        adapter = StartAdapter()
        recyclerView.adapter = adapter
        viewModel.getNalMoney()
        viewModel.myMoneyList.observe(viewLifecycleOwner) { list ->
            list.body()?.let { adapter.setList(it) }
        }
        return v

    }
}