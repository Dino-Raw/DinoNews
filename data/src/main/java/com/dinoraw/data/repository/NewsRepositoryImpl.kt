package com.dinoraw.data.repository

import com.dinoraw.data.remote.NewsRmoteDataSource
import com.dinoraw.domain.model.News
import com.dinoraw.domain.model.RequestParams
import com.dinoraw.domain.repository.remote.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsRmoteDataSource: NewsRmoteDataSource,
): NewsRepository {
    override suspend fun getNewsHeadline(requestParams: RequestParams): Result<News> =
        newsRmoteDataSource.getNewsHeadline(requestParams)
}