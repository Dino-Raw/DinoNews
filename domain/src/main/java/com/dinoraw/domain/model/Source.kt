package com.dinoraw.domain.model

import androidx.compose.runtime.Immutable
import kotlinx.serialization.Serializable

@Immutable
@Serializable
data class Source(
    val id: String?,
    val name: String?,
)