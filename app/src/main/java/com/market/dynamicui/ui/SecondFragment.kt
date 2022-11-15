package com.market.dynamicui.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.market.dynamicui.R
import com.market.dynamicui.databinding.FragmentSecondBinding
import com.market.dynamicui.domain.BannerItem
import com.market.dynamicui.domain.CardItem
import com.market.dynamicui.domain.CircleItem
import com.market.dynamicui.domain.RectItem

class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var cardItemBundleData: CardItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_second,
            container,
            false
        )
        binding.apply {
            lifecycleOwner = this@SecondFragment
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments?.getParcelable<CircleItem>("circleItem") != null) {
            cardItemBundleData = arguments?.getParcelable<CircleItem>("circleItem")!!
        } else if (arguments?.getParcelable<RectItem>("rectItem") != null) {
            cardItemBundleData = arguments?.getParcelable<RectItem>("rectItem")!!
        } else if (arguments?.getParcelable<BannerItem>("bannerItem") != null) {
            cardItemBundleData = arguments?.getParcelable<BannerItem>("bannerItem")!!
        }

        var title: String = ""
        var color: String = ""
        when (cardItemBundleData) {
            is CircleItem -> {
                title = (cardItemBundleData as CircleItem).title
                color = (cardItemBundleData as CircleItem).iconColor
            }
            is BannerItem -> {
                title = (cardItemBundleData as BannerItem).title
                color = (cardItemBundleData as BannerItem).backgroundColor
            }
            is RectItem -> {
                title = (cardItemBundleData as RectItem).title
                color = (cardItemBundleData as RectItem).thumbnailColor
            }
        }
        binding.secondColor.setBackgroundColor(Color.parseColor(color))
        binding.secondTitle.text = title

    }
}