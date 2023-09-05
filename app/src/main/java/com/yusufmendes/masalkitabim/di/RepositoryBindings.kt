package com.yusufmendes.masalkitabim.di

import com.yusufmendes.masalkitabim.domain.repos.FairytaleRepository
import com.yusufmendes.masalkitabim.repository.FairytaleRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindAuthRepository(fairytaleRepositoryImpl: FairytaleRepositoryImpl): FairytaleRepository
}