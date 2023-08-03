package com.example.newsapp.domain.usecases

import com.example.newsapp.data.models.Article
import com.example.newsapp.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(article: Article)= newsRepository.saveNews(article)
}