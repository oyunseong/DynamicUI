package com.market.dynamicui.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.market.myzepeto.R
import com.market.myzepeto.databinding.FragmentFirstBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val cardViewModel by viewModels<CardViewModel>()
    private val cardAdapter = CardAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_first,
            container,
            false
        )
        binding.apply {
            lifecycleOwner = this@HomeFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setCardRecyclerView()
        cardViewModel.cardDataList.observe(viewLifecycleOwner) {
            cardAdapter.setList(it)
        }

    }

    private fun setCardRecyclerView() {
        binding.cardRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = cardAdapter
        }
    }
}