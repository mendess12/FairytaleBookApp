package com.yusufmendes.masalkitabim.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yusufmendes.masalkitabim.databinding.ViewPagerItemRowBinding
import com.yusufmendes.masalkitabim.model.Fairytale
import com.yusufmendes.masalkitabim.util.downloadFromUrl


class ViewPagerAdapter(
    private var fairytaleList: List<Fairytale>,
    private val onClick: (Fairytale) -> Unit
) :
    RecyclerView.Adapter<ViewPagerAdapter.PagerViewHolder>() {

    inner class PagerViewHolder(val binding: ViewPagerItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(fairytale: Fairytale) {
            with(binding) {
                viewPagerNameTv.text = fairytale.name
                viewPagerFairytaleTv.text = fairytale.fairytale
                fairytale.imageUrl?.let { viewPagerIv.downloadFromUrl(it) }
                itemView.setOnClickListener {
                    onClick.invoke(fairytale)
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.PagerViewHolder {
        val binding =
            ViewPagerItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.PagerViewHolder, position: Int) {
        val fairytalePosition = fairytaleList[position]
        holder.bind(fairytalePosition)
    }

    override fun getItemCount(): Int {
        return fairytaleList.size
    }
}