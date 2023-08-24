package com.yusufmendes.masalkitabim.view.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.yusufmendes.masalkitabim.R
import com.yusufmendes.masalkitabim.databinding.FragmentListBinding


class ListFragment : Fragment(R.layout.fragment_list) {

    private lateinit var binding: FragmentListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
    }
}