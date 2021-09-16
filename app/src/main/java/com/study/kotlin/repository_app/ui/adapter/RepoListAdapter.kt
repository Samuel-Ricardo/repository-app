package com.study.kotlin.repository_app.ui.adapter

import androidx.recyclerview.widget.ListAdapter
import com.study.kotlin.repository_app.data.model.Repo

class RepoListAdapter: ListAdapter<Repo, RepoListAdapter.ViewHolder>(DiffCallback()) {
}