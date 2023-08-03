package com.example.newsapp.domain.usecases

import com.example.newsapp.data.models.Article
import com.example.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNews(private val newsRepository: NewsRepository) {
    fun execute():Flow<List<Article>>{
        return newsRepository.getSavedNews()
    }
}