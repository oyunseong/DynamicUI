package com.market.dynamicui.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.market.dynamicui.domain.*
import com.market.dynamicui.utils.showToast
import com.market.dynamicui.R
import com.market.dynamicui.databinding.FragmentFirstBinding

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private val cardViewModel by viewModels<CardViewModel>()
    private val cardAdapter = CardAdapter(onItemClickListener = { it, position ->
        when (it) {
            is CircleItem -> {
                requireContext().showToast("${position}번째 아이템 클릭")
                findNavController().navigate(
                    R.id.action_FirstFragment_to_SecondFragment,
                    bundleOf("circleItem" to it)
                )
            }
            is BannerItem -> {
                findNavController().navigate(
                    R.id.action_FirstFragment_to_SecondFragment,
                    bundleOf("bannerItem" to it)
                )
                requireContext().showToast("${position}번째 아이템 클릭")
            }
            is RectItem -> {
                findNavController().navigate(
                    R.id.action_FirstFragment_to_SecondFragment,
                    bundleOf("rectItem" to it)
                )
                requireContext().showToast("${position}번째 아이템 클릭")
            }

            else -> {
                requireContext().showToast("뭘 클릭한거야??")
            }
        }
    })

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