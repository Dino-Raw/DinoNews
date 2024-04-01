package com.dinoraw.data.remote

import com.dinoraw.data.utils.httpclient.HttpClientExtension.request
import com.dinoraw.data.utils.httpclient.HttpClientProvider
import com.dinoraw.domain.model.News
import com.dinoraw.domain.model.RequestParams
import javax.inject.Inject

class NewsRemoteDataSourceImpl @Inject constructor(
    private val httpClientProvider: HttpClientProvider,
): NewsRmoteDataSource {
    override suspend fun getNewsHeadline(requestParams: RequestParams): Result<News> = runCatching {
        httpClientProvider.client.request<News>(requestParams).convert
    }
}