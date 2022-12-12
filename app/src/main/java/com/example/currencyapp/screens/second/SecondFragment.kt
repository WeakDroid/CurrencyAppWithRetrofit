package com.example.currencyapp.screens.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyapp.R
import com.example.currencyapp.databinding.FragmentSecondBinding
import kotlinx.android.synthetic.main.fragment_second.view.*


class SecondFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SecondAdapter
    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        val viewModel = ViewModelProvider(this)[SecondViewModel::class.java]
        val view = inflater.inflate(R.layout.fragment_second, container, false)
        recyclerView = view.rv_second
        adapter = SecondAdapter()
        recyclerView.adapter = adapter
        viewModel.getBeznalMoney()
        viewModel.myMoneyList.observe(viewLifecycleOwner) { list ->
            list.body()?.let { adapter.setList(it) }
        }
        return view
    }
}