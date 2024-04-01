package com.dinoraw.domain.usecase

import com.dinoraw.domain.model.News
import com.dinoraw.domain.model.RequestParams
import com.dinoraw.domain.repository.remote.NewsRepository

class GetNewsHeadlineUseCase(private val repository: NewsRepository) {
    suspend fun execute(queryParams: RequestParams): Result<News> =
        repository.getNewsHeadline(queryParams)
}