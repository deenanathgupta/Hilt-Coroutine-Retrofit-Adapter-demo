package com.android.hilt_coroutine_retrofit_adapter_demo.api

import com.android.hilt_coroutine_retrofit_adapter_demo.model.AlbumResponseModelItem
import com.android.hilt_coroutine_retrofit_adapter_demo.network.NetworkResult


interface IAlbumDataSource {

    suspend fun getAlbumList():NetworkResult<List<AlbumResponseModelItem>>
}