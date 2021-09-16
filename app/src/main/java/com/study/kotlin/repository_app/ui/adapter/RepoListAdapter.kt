package com.study.kotlin.repository_app.ui.adapter

import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.study.kotlin.repository_app.data.model.Repo
import com.study.kotlin.repository_app.databinding.RepoLayoutBinding

class RepoListAdapter: ListAdapter<Repo, RepoListAdapter.ViewHolder>(DiffCallback()) {

    inner class ViewHolder(
        private val binding: RepoLayoutBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Repo) {
            binding.tvRepoName.text = item.name;
            binding.tvRepoDescription.text = item.description;
            binding.tvRepoLanguage.text = item.language;
            binding.chipStar.text = item.stargazersCount.toString()

            Glide.with(binding.root.context)
                .load(item.owner.profileImageURL)
                .into(binding.ivOwner)
        }
    }

}