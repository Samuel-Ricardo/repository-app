package com.study.kotlin.repository_app.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.study.kotlin.repository_app.R;
import com.study.kotlin.repository_app.core.createProgressDialog;
import com.study.kotlin.repository_app.databinding.ActivityMainBinding;
import com.study.kotlin.repository_app.presentation.MainViewModel;
import com.study.kotlin.repository_app.ui.adapter.RepoListAdapter;
import org.koin.androidx.viewmodel.ext.android.viewModel;

class MainActivity : AppCompatActivity() {

    private val dialog by lazy { createProgressDialog() };
    private val viewModel by viewModel<MainViewModel>();
    private val adapter by lazy { RepoListAdapter() };
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) };

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(binding.root);

        setup();
    }

    private fun setup() {
        setupActionBar();
        binding.rvRepos.adapter = adapter;
    }

    private fun setupActionBar() {
        setSupportActionBar(binding.toolbar);
    }
}
