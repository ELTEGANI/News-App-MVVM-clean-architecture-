package com.example.newsapp.domain.usecases

import com.example.newsapp.data.models.ApiResponse
import com.example.newsapp.data.util.Resource
import com.example.newsapp.domain.repository.NewsRepository

class GetSearchNews(private val newsRepository: NewsRepository) {
    suspend fun execute(searchQuery:String):Resource<ApiResponse>{
        return newsRepository.getSearchNews(searchQuery)
    }
}