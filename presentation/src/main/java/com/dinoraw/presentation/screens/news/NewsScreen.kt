package com.dinoraw.presentation.screens.news

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.dinoraw.domain.model.Category
import com.dinoraw.presentation.screens.news.component.NewsPage
import com.dinoraw.presentation.screens.news.component.TabLayout

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NewsScreen() {
    val pagerState = rememberPagerState(pageCount = { Category.entries.size })

    Column {
        TabLayout(pagerState = pagerState)
        HorizontalPager(state = pagerState) { page ->
            val viewModel: NewsViewModel = hiltViewModel(
                key = page.toString(),
                creationCallback = { factory: NewsViewModel.NewsViewModelFactory ->
                    factory.create(Category.entries[page].value)
                },
            )
            NewsPage(viewModel = viewModel)
        }
    }
}