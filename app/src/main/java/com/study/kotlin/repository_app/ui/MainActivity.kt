package com.study.kotlin.repository_app.ui;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log
import android.view.Menu
import android.widget.SearchView
import com.study.kotlin.repository_app.R
import com.study.kotlin.repository_app.core.createDialog
import com.study.kotlin.repository_app.core.createProgressDialog;
import com.study.kotlin.repository_app.core.hideSoftKeyboard
import com.study.kotlin.repository_app.databinding.ActivityMainBinding;
import com.study.kotlin.repository_app.presentation.MainViewModel;
import com.study.kotlin.repository_app.ui.adapter.RepoListAdapter;
import org.koin.androidx.viewmodel.ext.android.viewModel;

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    companion object {
        private const val TAG = "TAG";
    }

    private val dialog by lazy { createProgressDialog() };
    private val viewModel by viewModel<MainViewModel>();
    private val adapter by lazy { RepoListAdapter() };
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) };

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(binding.root);

        setup();
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        val searchView =  menu.findItem(R.id.action_search).actionView as SearchView;
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu)
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        query?.let{viewModel.getRepoList((it))}
        binding.root.hideSoftKeyboard()
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
       Log.e(TAG, "onQueryTextChange: $newText")
        return false;
    }

    fun setup() {
        setupActionBar();
        setupRepoList();
    }

    private fun setupRepoList() {
        binding.rvRepos.adapter = adapter;

        updateRepoListItemsOrErrorDialog();
    }

    private fun updateRepoListItemsOrErrorDialog() {
        viewModel.repos.observe(this){
            when (it) {
                MainViewModel.State.Loading -> dialog.show();
                is MainViewModel.State.Error -> {
                    createDialog {
                        setMessage(it.error.message);
                    }.show();
                    dialog.dismiss();
                }
                is MainViewModel.State.Success -> {
                    dialog.dismiss();
                    adapter.submitList(it.list)
                }
            }
        }
    }

    private fun setupActionBar() {
        setSupportActionBar(binding.toolbar);
    }
}
