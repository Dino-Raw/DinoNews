package com.dinoraw.dinonews.di

import com.dinoraw.domain.model.RequestParams
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Provides
    fun provideRequestParams(): RequestParams = RequestParams()
}