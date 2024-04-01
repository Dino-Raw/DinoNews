package com.dinoraw.presentation.screens.news.component


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.UriHandler
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dinoraw.presentation.screens.news.NewsViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsPage(
    viewModel: NewsViewModel,
) {
    val newsState = viewModel.newsState.collectAsStateWithLifecycle()
    val refreshState = rememberPullToRefreshState()
    val onClick = remember { { url: String, uriHandler: UriHandler -> uriHandler.openUri(url) } }

    LaunchedEffect(refreshState.isRefreshing) {
        if (refreshState.isRefreshing) {
            viewModel.refreshNews()
            refreshState.endRefresh()
        }
    }

    Box(
        Modifier
            .fillMaxSize()
            .nestedScroll(refreshState.nestedScrollConnection)
            .clipToBounds()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            if (newsState.value.articles.isNotEmpty())
                itemsIndexed(
                    items = newsState.value.articles,
                    key = { _, item -> item.url!!}
                ) { index, article ->
                    NewsItem (article, onClick)
                    if (index == newsState.value.articles.size - 1 && !newsState.value.isLastPage) {
                        viewModel.getNews()
                    }
                }

            item {
                if (newsState.value.isFailure)
                    NewsItemFailed(viewModel::getNews, Modifier.align(Alignment.Center))
                else if (!newsState.value.isLastPage)
                    CircularProgressIndicator(Modifier.padding(32.dp).align(Alignment.Center))
            }
        }

        PullToRefreshContainer(state = refreshState, Modifier.align(Alignment.TopCenter))
    }
}