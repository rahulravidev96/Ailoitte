package com.example.ailottecompany

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ailottecompany.data.model.NewsApus
import kotlinx.coroutines.Job


class NewsViewModel(
    private val repository: NewsRepository
) : ViewModel() {

    private lateinit var job: Job

    private val _news = MutableLiveData<List<NewsApus>>()
    val news: LiveData<List<NewsApus>>
        get() = _news

    fun getNews() {
        job = Coroutines.ioThenMain(
            { repository.getMovies() },
            { _news.value = it }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if(::job.isInitialized) job.cancel()
    }
}
