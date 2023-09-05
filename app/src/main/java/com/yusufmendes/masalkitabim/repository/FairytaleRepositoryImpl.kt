package com.yusufmendes.masalkitabim.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.yusufmendes.masalkitabim.domain.repos.FairytaleRepository
import com.yusufmendes.masalkitabim.model.Fairytale
import com.yusufmendes.masalkitabim.util.FairytaleConst
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FairytaleRepositoryImpl @Inject constructor(private val firebaseDatabaseStore: FirebaseFirestore) :
    FairytaleRepository {

    override suspend fun getFairytaleList(): List<Fairytale> {
        return firebaseDatabaseStore.collection(FairytaleConst.FAIRYTALE)
            .get()
            .await()
            .toObjects(Fairytale::class.java)
    }
}