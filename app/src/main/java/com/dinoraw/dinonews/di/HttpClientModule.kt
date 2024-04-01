package com.dinoraw.dinonews.di

import com.dinoraw.data.utils.httpclient.HttpClientProvider
import com.dinoraw.data.utils.httpclient.HttpClientProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HttpClientModule {
    @Binds
    abstract fun bindHttpClientProvider(httpClientProviderImpl: HttpClientProviderImpl): HttpClientProvider
}