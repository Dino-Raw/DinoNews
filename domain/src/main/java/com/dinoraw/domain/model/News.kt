package com.dinoraw.domain.model

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class News(
    val articles: List<Articles>?,
) {
    val convert: News get() = copy(articles = articles
        ?.filter { article ->
            !article.url.isNullOrBlank() && "removed" !in article.url
        }?.map {
            article -> article.copy(publishedAt = article.publishedAtConverted())
        }
    )
}

