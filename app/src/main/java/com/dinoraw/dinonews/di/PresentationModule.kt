package com.dinoraw.dinonews.di

import com.dinoraw.presentation.screens.news.model.NewsState
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object PresentationModule  {
    @Provides
    fun provideNewsState(): NewsState = NewsState()
}