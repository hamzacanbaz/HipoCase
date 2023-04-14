package com.canbazdev.hipocase.di

import com.canbazdev.hipocase.data.remote.HipoService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import kotlin.text.Typography.dagger

/*
*   Created by hamzacanbaz on 19.06.2022
*/
@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideRickAndMortyService(): HipoService {
        return Retrofit.Builder()
            .baseUrl("https://gist.github.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(HipoService::class.java)
    }
}
