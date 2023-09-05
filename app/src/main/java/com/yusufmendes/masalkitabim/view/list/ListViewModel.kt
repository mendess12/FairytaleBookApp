package com.yusufmendes.masalkitabim.view.list

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yusufmendes.masalkitabim.domain.usecases.GetFairytaleUseCase
import com.yusufmendes.masalkitabim.model.Fairytale
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getFairytaleUseCase: GetFairytaleUseCase
) : ViewModel() {

    var listLiveData: MutableLiveData<List<Fairytale>?> = MutableLiveData()

    fun getDataFromFirebase() {
        viewModelScope.launch {
            try {
                val result = getFairytaleUseCase(Unit)
                listLiveData.postValue(result)
            } catch (exception: Exception) {
                Log.e("Fairytale list error", exception.toString())
                listLiveData.postValue(null)
            }
        }
    }
}