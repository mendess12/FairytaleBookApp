package com.yusufmendes.masalkitabim.domain.usecases

import com.yusufmendes.masalkitabim.domain.repos.FairytaleRepository
import com.yusufmendes.masalkitabim.model.Fairytale
import javax.inject.Inject

class GetFairytaleUseCase @Inject constructor(
    private val fairytaleRepository: FairytaleRepository
) : SuspendUseCase<Unit, List<Fairytale>>() {
    override suspend fun execute(params: Unit): List<Fairytale> {
        return fairytaleRepository.getFairytaleList()
    }
}