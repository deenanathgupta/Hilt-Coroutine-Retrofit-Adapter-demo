package com.android.hilt_coroutine_retrofit_adapter_demo.repository

import com.android.hilt_coroutine_retrofit_adapter_demo.api.AlbumRemoteDataSource
import javax.inject.Inject

class AlbumRepository @Inject constructor(private val remoteDataSource: AlbumRemoteDataSource) {
    suspend fun getAlbumList() = remoteDataSource.getAlbumList()
}