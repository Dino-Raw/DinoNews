package com.dinoraw.data.utils.httpclient

import io.ktor.client.HttpClient

interface HttpClientProvider {
    val client: HttpClient
}