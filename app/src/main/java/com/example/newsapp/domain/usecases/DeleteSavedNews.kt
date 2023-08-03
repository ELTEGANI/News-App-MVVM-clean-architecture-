package com.example.newsapp.domain.usecases

import com.example.newsapp.data.models.Article
import com.example.newsapp.domain.repository.NewsRepository

class DeleteSavedNews(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.deleteNews(article)
}