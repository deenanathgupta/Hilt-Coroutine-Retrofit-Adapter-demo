package com.android.hilt_coroutine_retrofit_adapter_demo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.hilt_coroutine_retrofit_adapter_demo.adapter.AlbumAdapter
import com.android.hilt_coroutine_retrofit_adapter_demo.databinding.ActivityMainBinding
import com.android.hilt_coroutine_retrofit_adapter_demo.viewmodel.AlbumViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<AlbumViewModel>()
    private var albumAdapter = AlbumAdapter(emptyList())
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initView()
        viewModel.getAlbumList()
        viewModel.albumList.observe(this) {
            (binding.rvTrendingRepos.adapter as AlbumAdapter).updateData(it)
        }
    }

    private fun initView() {
        with(binding.rvTrendingRepos) {
            layoutManager = LinearLayoutManager(this.context)
            adapter = albumAdapter
        }
    }
}