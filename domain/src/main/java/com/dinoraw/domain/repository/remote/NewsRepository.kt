package com.dinoraw.domain.repository.remote

import com.dinoraw.domain.model.News
import com.dinoraw.domain.model.RequestParams

interface NewsRepository {
    suspend fun getNewsHeadline(requestParams: RequestParams): Result<News>
}