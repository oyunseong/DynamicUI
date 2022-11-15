package com.market.dynamicui.ui.home

import android.os.Bundle
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
import com.market.dynamicui.model.server.MapleAPI
import com.market.dynamicui.model.server.RetrofitClient
import com.market.dynamicui.utils.printLog
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    lateinit var retrofit: Retrofit
    lateinit var mapleAPI: MapleAPI
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
        initServer()
    }

    private fun setCardRecyclerView() {
        binding.cardRecyclerView.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = cardAdapter
        }
    }

    private fun initServer() {
        "++initServer call".printLog()
        retrofit = RetrofitClient.getInstance()
        mapleAPI = retrofit.create(MapleAPI::class.java)

        Runnable {
            mapleAPI.getData().enqueue(object : retrofit2.Callback<Maple> {
                override fun onResponse(call: Call<Maple>, response: Response<Maple>) {
                    val data = response.body()
                    if (data == null) {
                        requireContext().showToast("데이터가 없습니다.")
                    }
                    "++onResponse".printLog("initServer")
                }

                override fun onFailure(call: Call<Maple>, t: Throwable) {
                    "onFailure message : " + t.message.toString().printLog("initServer")
                }

            })
        }.run()
    }
}