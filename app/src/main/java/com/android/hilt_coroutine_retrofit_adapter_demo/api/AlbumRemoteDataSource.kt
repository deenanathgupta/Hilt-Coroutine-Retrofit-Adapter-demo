package com.android.hilt_coroutine_retrofit_adapter_demo.api

import com.android.hilt_coroutine_retrofit_adapter_demo.model.AlbumResponseModelItem
import com.android.hilt_coroutine_retrofit_adapter_demo.network.NetworkResult
import javax.inject.Inject

class AlbumRemoteDataSource @Inject constructor(private val service: APIService) :
    IAlbumDataSource {
    override suspend fun getAlbumList(): NetworkResult<List<AlbumResponseModelItem>> {
        return service.getAlbumList()
    }
}