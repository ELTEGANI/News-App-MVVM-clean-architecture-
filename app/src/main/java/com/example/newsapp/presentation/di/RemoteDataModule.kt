package com.example.newsapp.presentation.di

import com.example.newsapp.data.api.NewsApiServices
import com.example.newsapp.data.repository.datasource.NewsRemoteDataSource
import com.example.newsapp.data.repository.datasourceImpl.NewsDataSourceImplementation
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {
    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(
        newsApiServices: NewsApiServices
    ):NewsRemoteDataSource{
        return NewsDataSourceImplementation(newsApiServices)
    }
}