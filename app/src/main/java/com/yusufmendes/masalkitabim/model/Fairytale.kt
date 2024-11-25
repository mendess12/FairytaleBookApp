package com.yusufmendes.masalkitabim.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Fairytale
    (
    val name: String? = null,
    val fairytale: String? = null,
    val imageUrl: String? = null,
    val sound: String? = null
) :
    Parcelable