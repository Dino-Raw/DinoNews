package com.dinoraw.domain.model

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Immutable
@Serializable
data class Articles(
    val source: Source?,
    val author: String?,
    val title: String?,
    val description: String?,
    val url: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val content: String?,
) {
    @Suppress("SimpleDateFormat")
    fun publishedAtConverted(): String {
        val dateFormatFrom: DateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        val dateFormatTo: DateFormat = SimpleDateFormat("yyyy-MM-dd")
        val parsedDateFrom = dateFormatFrom.parse(this.publishedAt)
        val formattedDateTo = dateFormatTo.format(parsedDateFrom!!)
        return LocalDate.parse(formattedDateTo.toString(), DateTimeFormatter.ISO_DATE).toString()
    }
}