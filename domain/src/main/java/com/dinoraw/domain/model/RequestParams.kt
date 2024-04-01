package com.dinoraw.domain.model


data class RequestParams(
    val apiKey: RequestParam = RequestParam("apiKey", "insert api key"),
    val searchWord: RequestParam = RequestParam("q", ""),
    val sources: RequestParam = RequestParam("sources", ""),
    val pageSize: RequestParam = RequestParam("pageSize", "20"),
    val page: RequestParam = RequestParam("page", "1"),
    val category: RequestParam = RequestParam("category", ""),
    val country: RequestParam = RequestParam("country", "us"),
) {
    fun toList(): List<RequestParam> =
        listOf(apiKey, searchWord, sources, pageSize, page, category, country)
}