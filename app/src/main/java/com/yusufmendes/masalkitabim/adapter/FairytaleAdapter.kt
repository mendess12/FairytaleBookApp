package com.yusufmendes.masalkitabim.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.yusufmendes.masalkitabim.databinding.ViewPagerItemRowBinding
import com.yusufmendes.masalkitabim.model.Fairytale
import com.yusufmendes.masalkitabim.util.downloadFromUrl
import java.util.Locale

class FairytaleAdapter(
    private val onClick: (Fairytale) -> Unit
) :
    RecyclerView.Adapter<FairytaleAdapter.PagerViewHolder>(), Filterable {

    private var fairytaleList: MutableList<Fairytale> = arrayListOf()
    private var filterFairytale: MutableList<Fairytale> = arrayListOf()


    inner class PagerViewHolder(private val binding: ViewPagerItemRowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(fairytale: Fairytale) {
            with(binding) {
                viewPagerNameTv.text = fairytale.name
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
    ): FairytaleAdapter.PagerViewHolder {
        val binding =
            ViewPagerItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FairytaleAdapter.PagerViewHolder, position: Int) {
        val fairytalePosition = filterFairytale[position]
        holder.bind(fairytalePosition)
    }

    override fun getItemCount(): Int {
        return filterFairytale.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun publishResults(constraint: CharSequence, results: FilterResults) {
                filterFairytale = results.values as MutableList<Fairytale>
                notifyDataSetChanged()
            }

            override fun performFiltering(constraint: CharSequence): FilterResults {
                val filteredResults: List<Fairytale?> = if (constraint.isEmpty()) {
                    fairytaleList
                } else {
                    getFilteredResults(constraint.toString().lowercase(Locale.getDefault()))
                }
                val results = FilterResults()
                results.values = filteredResults
                return results
            }
        }
    }

    private fun getFilteredResults(constraint: String?): List<Fairytale> {
        val results: MutableList<Fairytale> = ArrayList()
        for (item in fairytaleList) {
            if (item.name != null) {
                if (item.name.lowercase().contains(constraint!!)) {
                    results.add(item)
                }
            }
        }
        return results
    }

    fun updateData(fairytale: List<Fairytale>) {
        filterFairytale.clear()
        filterFairytale.addAll(fairytale)
        fairytaleList.clear()
        fairytaleList.addAll(fairytale)
        notifyDataSetChanged()
    }

    /*
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun publishResults(constraint: CharSequence, results: FilterResults) {
                filterList = results.values as MutableList<CryptoListItem>
                notifyDataSetChanged()
            }

            override fun performFiltering(constraint: CharSequence): FilterResults {
                val filteredResults: List<CryptoListItem?> = if (constraint.isEmpty()) {
                    cryptoData
                } else {
                    getFilteredResults(constraint.toString().lowercase(Locale.getDefault()))
                }
                val results = FilterResults()
                results.values = filteredResults
                return results
            }
        }
    }

    //filtre sonuçları
    private fun getFilteredResults(constraint: String?): List<CryptoListItem> {
        val results: MutableList<CryptoListItem> = ArrayList()
        for (item in cryptoData) {
            if (item.name.lowercase().contains(constraint!!)) {
                results.add(item)
            }
        }
        return results
    }

    fun updateData(crypto: List<CryptoListItem>) {
        filterList.clear()
        filterList.addAll(crypto)
        cryptoData.clear()
        cryptoData.addAll(crypto)
        notifyDataSetChanged()
    }
    *
    * */
}