package com.dinoraw.data.utils.httpclient

import android.util.Log
import com.dinoraw.data.utils.Const
import com.dinoraw.domain.model.RequestParams
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.statement.HttpResponse
import io.ktor.http.isSuccess

object HttpClientExtension {
    suspend inline fun <reified RESPONSE> HttpClient.request(
        requestParams: RequestParams,
    ): RESPONSE {
        val response = get(Const.URL) {
            for (param in requestParams.toList())
                if (param.value.isNotBlank()) parameter(param.name, param.value)
        }.body<HttpResponse>()

        if (!response.status.isSuccess())
            throw Exception(response.status.description)

        Log.d("DINO DATA", "SUCCESS ${response.body<RESPONSE>()}")
        return response.body<RESPONSE>()
    }
}