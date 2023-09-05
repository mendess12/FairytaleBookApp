package com.yusufmendes.masalkitabim.domain.repos

import com.yusufmendes.masalkitabim.model.Fairytale

interface FairytaleRepository {

    suspend fun getFairytaleList(): List<Fairytale>
}