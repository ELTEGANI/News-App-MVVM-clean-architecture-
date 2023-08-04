package com.example.newsapp.presentation.viewmodels

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.domain.usecases.GetNewsHeadlinesUseCase

class NewsModelsFactory(
    private val application: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(
            application,
            getNewsHeadlinesUseCase
        ) as T
    }
}