package com.dinoraw.presentation.screens.news.model

import com.dinoraw.domain.model.Articles

data class NewsState (
    val isFailure: Boolean = false,
    val isLastPage: Boolean = false,
    val pageNum: Int = 1,
    val articles: List<Articles> = emptyList()
)
