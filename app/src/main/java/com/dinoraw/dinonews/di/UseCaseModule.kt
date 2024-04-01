package com.dinoraw.dinonews.di

import com.dinoraw.domain.repository.remote.NewsRepository
import com.dinoraw.domain.usecase.GetNewsHeadlineUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideGetNewsHeadlineUseCase(repository: NewsRepository) =
        GetNewsHeadlineUseCase(repository = repository)
}