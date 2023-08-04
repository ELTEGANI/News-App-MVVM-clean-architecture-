package com.example.newsapp.data.repository

import com.example.newsapp.data.models.ApiResponse
import com.example.newsapp.data.models.Article
import com.example.newsapp.data.repository.datasource.NewsRemoteDataSource
import com.example.newsapp.data.util.Resource
import com.example.newsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource
):NewsRepository {
    override suspend fun getNewsHeadLines(country:String,page:Int): Resource<ApiResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadLines(country,page))
    }

    private fun responseToResource(response: Response<ApiResponse>):Resource<ApiResponse>{
        if (response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }
    override suspend fun getSearchNews(searchQuery: String): Resource<ApiResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }
}