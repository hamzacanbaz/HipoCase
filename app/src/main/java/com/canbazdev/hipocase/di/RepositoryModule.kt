package com.canbazdev.hipocase.di

import com.canbazdev.hipocase.data.remote.HipoService
import com.canbazdev.hipocase.data.repository.HipoRepositoryImpl
import com.canbazdev.hipocase.domain.repository.HipoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/*
*   Created by hamzacanbaz on 4/5/2023
*/
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideRickAndMortyRepository(rickAndMortyService: HipoService): HipoRepository {
        return HipoRepositoryImpl(rickAndMortyService)
    }
}