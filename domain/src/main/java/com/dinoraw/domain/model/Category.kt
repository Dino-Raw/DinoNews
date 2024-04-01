package com.dinoraw.domain.model

import androidx.compose.runtime.Immutable

@Immutable
enum class Category(val value: String) {
    GENERAL("general"),
    BUSINESS("business"),
    ENTERTAINMENT("entertainment"),
    HEALTH("health"),
    SCIENCE("science"),
    SPORTS("sports"),
    TECHNOLOGY("technology");
}