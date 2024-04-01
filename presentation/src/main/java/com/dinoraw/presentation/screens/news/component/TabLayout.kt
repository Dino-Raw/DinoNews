package com.dinoraw.presentation.screens.news.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import com.dinoraw.domain.model.Category
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayout(
    pagerState: PagerState,
) {
    val scope = rememberCoroutineScope()

    ScrollableTabRow(
        modifier = Modifier,
        selectedTabIndex = pagerState.currentPage,
        indicator = { tabPositions ->
            SecondaryIndicator(
                modifier = Modifier.tabIndicatorOffset(tabPositions[pagerState.currentPage]),
            )
        },
        tabs = {
            Category.entries.forEachIndexed { index, category ->
                Tab(
                    modifier = Modifier.padding(8.dp),
                    selected = index == pagerState.currentPage,
                    onClick = { scope.launch { pagerState.scrollToPage(index) } },
                    text = {
                        Text(
                            text = category.value.replaceFirstChar { it.uppercase() },
                            style = MaterialTheme.typography.bodyMedium,
                            fontFamily = FontFamily.Default,
                        )
                    },
                    selectedContentColor = colorScheme.primary,
                    unselectedContentColor = colorScheme.secondary,
                )
            }
        },
    )
}