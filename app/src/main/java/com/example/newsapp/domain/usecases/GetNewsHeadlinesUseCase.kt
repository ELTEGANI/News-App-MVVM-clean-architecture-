package com.example.newsapp.domain.usecases

import com.example.newsapp.data.models.ApiResponse
import com.example.newsapp.data.util.Resource
import com.example.newsapp.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase (private val newsRepository: NewsRepository){
    //business logic and we could modify data here
    suspend fun execute(country:String,page:Int): Resource<ApiResponse>{
        return newsRepository.getNewsHeadLines(country,page)
    }
}