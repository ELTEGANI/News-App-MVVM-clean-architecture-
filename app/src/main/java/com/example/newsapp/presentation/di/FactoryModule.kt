package com.example.newsapp.presentation.di

import android.app.Application
import com.example.newsapp.domain.usecases.GetNewsHeadlinesUseCase
import com.example.newsapp.presentation.viewmodels.NewsModelsFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {
    @Provides
    @Singleton
    fun provideNewsViewModelFactory(
        application: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase
    ):NewsModelsFactory{
        return NewsModelsFactory(
            application,
            getNewsHeadlinesUseCase
        )
    }
}