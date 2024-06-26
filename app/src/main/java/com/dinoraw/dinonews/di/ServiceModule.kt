package com.dinoraw.dinonews.di

import com.dinoraw.data.remote.NewsRemoteDataSourceImpl
import com.dinoraw.data.remote.NewsRmoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {
    @Binds
    abstract fun bindNewsService(newsRemoteDataSourceImpl: NewsRemoteDataSourceImpl): NewsRmoteDataSource
}