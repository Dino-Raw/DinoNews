package com.dinoraw.presentation.screens.news

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dinoraw.domain.model.News
import com.dinoraw.domain.model.RequestParams
import com.dinoraw.domain.usecase.GetNewsHeadlineUseCase
import com.dinoraw.presentation.screens.news.model.NewsState
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = NewsViewModel.NewsViewModelFactory::class)
class NewsViewModel @AssistedInject constructor(
    private val getNewsHeadlineUseCase: GetNewsHeadlineUseCase,
    private val defaultRequestParams: RequestParams,
    defaultNewsState: NewsState,
    @Assisted private val newsCategory: String,
): ViewModel() {
    private var _newsState: MutableStateFlow<NewsState> = MutableStateFlow(defaultNewsState)
    val newsState: StateFlow<NewsState> = _newsState.asStateFlow()

    private val onSuccess: (News) -> Unit = { partNews ->
        if (!partNews.articles.isNullOrEmpty()) {
            _newsState.update { newsState ->
                newsState.copy(
                    articles = newsState.articles + partNews.articles!!
                        .filter { !newsState.articles.contains(it) },
                    pageNum = newsState.pageNum.plus(1)
                )
            }
        } else {
            _newsState.update { newsState -> newsState.copy(isLastPage = true) }
        }
    }

    private val onFailure: (String) -> Unit = { error ->
        _newsState.update { newsState -> newsState.copy(isFailure = true) }
    }

    @AssistedFactory
    interface NewsViewModelFactory {
        fun create(category: String): NewsViewModel
    }

    init {
        getNews()
    }

    fun getNews() {
        _newsState.update { newsState ->
            newsState.copy(
                isFailure = false,
                isLastPage = false,
            )
        }

        val requestParam = defaultRequestParams.copy(
            page = defaultRequestParams.page.copy(value = newsState.value.pageNum.toString()),
            category = defaultRequestParams.category.copy(value = newsCategory),
            pageSize = defaultRequestParams.pageSize.copy(value = newsCategory),
        )

        viewModelScope.launch(Dispatchers.IO) {
            getNewsHeadlineUseCase.execute(requestParam)
                .onSuccess { onSuccess(it) }
                .onFailure { onFailure(it.toString()) }
        }
    }

    fun refreshNews() {
        _newsState.update { newsState ->
            newsState.copy(
                articles = emptyList(),
                pageNum = 1,
            )
        }
        getNews()
    }
}