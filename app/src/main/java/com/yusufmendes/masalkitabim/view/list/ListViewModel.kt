package com.yusufmendes.masalkitabim.view.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusufmendes.masalkitabim.model.Fairytale
import com.yusufmendes.masalkitabim.repository.FairytaleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(private val fairytaleRepository: FairytaleRepository): ViewModel() {

    var listLiveData: MutableLiveData<List<Fairytale>?> = MutableLiveData()

    init {
        getDataFromFirebase()
    }

    fun getDataFromFirebase() {
        viewModelScope.launch {
            try {
                val result = fairytaleRepository.getFairytaleList()
                listLiveData.postValue(result)
            } catch (exception: Exception) {
                Log.e("Fairytale list error", exception.toString())
                listLiveData.postValue(null)
            }
        }
    }
}