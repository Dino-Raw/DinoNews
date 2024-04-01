package com.dinoraw.data.remote

import com.dinoraw.domain.model.News
import com.dinoraw.domain.model.RequestParams

interface NewsRmoteDataSource {
    suspend fun getNewsHeadline(requestParams: RequestParams): Result<News>
}