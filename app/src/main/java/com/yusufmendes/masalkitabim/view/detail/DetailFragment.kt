package com.yusufmendes.masalkitabim.view.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.yusufmendes.masalkitabim.R
import com.yusufmendes.masalkitabim.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var binding: FragmentDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)
    }

}