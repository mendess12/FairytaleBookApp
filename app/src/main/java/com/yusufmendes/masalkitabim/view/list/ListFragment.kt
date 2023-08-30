package com.yusufmendes.masalkitabim.view.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.yusufmendes.masalkitabim.R
import com.yusufmendes.masalkitabim.adapter.FairytaleAdapter
import com.yusufmendes.masalkitabim.databinding.FragmentListBinding
import com.yusufmendes.masalkitabim.model.Fairytale
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var binding: FragmentListBinding
    private val viewModel: ListViewModel by viewModels()
    private lateinit var fairytaleVPAdapter: FairytaleAdapter
    private lateinit var mAdView: AdView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        adMob()
        binding.rv.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        fairytaleVPAdapter = FairytaleAdapter(::navigateToDetail)
        binding.rv.adapter = fairytaleVPAdapter
        searchView()
        observeLiveData()
        viewModel.getDataFromFirebase()
    }

    private fun observeLiveData() {
        viewModel.listLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                fairytaleVPAdapter.updateData(it)
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

    private fun searchView() {
        binding.searchView.setOnQueryTextListener(object :
            SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText != null) {
                    fairytaleVPAdapter.filter.filter(newText)
                }
                return true
            }

        })
    }
}