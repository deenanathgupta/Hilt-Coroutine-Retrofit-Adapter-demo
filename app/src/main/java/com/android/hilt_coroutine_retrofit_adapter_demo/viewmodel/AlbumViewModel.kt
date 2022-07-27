package com.android.hilt_coroutine_retrofit_adapter_demo.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.hilt_coroutine_retrofit_adapter_demo.di.RepositoryModule
import com.android.hilt_coroutine_retrofit_adapter_demo.network.onError
import com.android.hilt_coroutine_retrofit_adapter_demo.network.onException
import com.android.hilt_coroutine_retrofit_adapter_demo.network.onSuccess
import com.android.hilt_coroutine_retrofit_adapter_demo.repository.AlbumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(private val repository: AlbumRepository, @RepositoryModule.IoDispatcher private val ioDispatcher: CoroutineDispatcher): ViewModel() {
    fun getAlbumList() {
        viewModelScope.launch(ioDispatcher) {
            val response = repository.getAlbumList()
            response.onSuccess {
                Log.d("DEENA", "onSuccess:${it.size} ")
            }
            response.onError { _, _ ->
                Log.d("DEENA", "onError: ")
            }
            response.onException {
                Log.d("DEENA", "onException: ")
            }
        }
    }
}