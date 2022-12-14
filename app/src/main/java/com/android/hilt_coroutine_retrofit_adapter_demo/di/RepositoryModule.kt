package com.android.hilt_coroutine_retrofit_adapter_demo.di

import com.android.hilt_coroutine_retrofit_adapter_demo.api.AlbumRemoteDataSource
import com.android.hilt_coroutine_retrofit_adapter_demo.api.IAlbumDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @DefaultDispatcher
    @Provides
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @IoDispatcher
    @Provides
    fun providesIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @MainDispatcher
    @Provides
    fun providesMainDispatcher(): CoroutineDispatcher = Dispatchers.Main

    @Retention(AnnotationRetention.BINARY)
    @Qualifier
    annotation class DefaultDispatcher

    @Retention(AnnotationRetention.BINARY)
    @Qualifier
    annotation class IoDispatcher

    @Retention(AnnotationRetention.BINARY)
    @Qualifier
    annotation class MainDispatcher

    @Provides
    @Singleton
    fun provideAlbumRemoteDataSource(albumRemoteDataSource: AlbumRemoteDataSource) : IAlbumDataSource = albumRemoteDataSource
}