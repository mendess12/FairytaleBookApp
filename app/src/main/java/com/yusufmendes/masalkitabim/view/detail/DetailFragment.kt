package com.yusufmendes.masalkitabim.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.yusufmendes.masalkitabim.R
import com.yusufmendes.masalkitabim.databinding.FragmentDetailBinding
import com.yusufmendes.masalkitabim.util.downloadFromUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()
    lateinit var mAdView: AdView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)

        adMob()

        binding.apply {
            detailScreenToolBar.toolBarNameTv.text = args.fairytale.name.toString()
            detailScreenFairytaleTv.text = args.fairytale.fairytale.toString()
            detailScreenIv.downloadFromUrl(args.fairytale.imageUrl.toString())
            detailScreenToolBar.toolBarBackIv.setOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

    private fun adMob() {
        MobileAds.initialize(requireContext())
        mAdView = binding.adView2
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }
}