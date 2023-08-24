package com.yusufmendes.masalkitabim.view.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.yusufmendes.masalkitabim.R
import com.yusufmendes.masalkitabim.adapter.ViewPagerAdapter
import com.yusufmendes.masalkitabim.databinding.FragmentListBinding
import com.yusufmendes.masalkitabim.model.Fairytale
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by viewModels()
    private lateinit var fairytaleVPAdapter: ViewPagerAdapter
    private lateinit var mAdView: AdView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        adMob()
        binding.viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        observeLiveData()
        viewModel.getDataFromFirebase()
    }

    private fun observeLiveData() {
        viewModel.listLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                fairytaleVPAdapter = ViewPagerAdapter(it, ::navigateToDetail)
                binding.viewPager2.adapter = fairytaleVPAdapter

            } else {
                Toast.makeText(requireContext(), "Liste boş!", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun navigateToDetail(fairytale: Fairytale) {
        val action = ListFragmentDirections.actionListFragmentToDetailFragment(fairytale)
        findNavController().navigate(action)
    }

    private fun adMob() {
        MobileAds.initialize(requireContext())
        mAdView = binding.adView
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)
    }

}