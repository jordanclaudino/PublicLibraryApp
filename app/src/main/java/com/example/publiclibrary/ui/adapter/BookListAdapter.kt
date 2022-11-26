package com.example.publiclibrary.ui.adapter

import android.R
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.publiclibrary.data.model.Book
import com.example.publiclibrary.databinding.RepoBookBinding


class BookListAdapter : ListAdapter<Book, BookListAdapter.ViewHolder>(BookDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RepoBookBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, positition: Int) {
        holder.bind(getItem(positition))
    }

    inner class ViewHolder(private val binding: RepoBookBinding) :
        RecyclerView.ViewHolder(binding.root){

        fun bind(item: Book){
            binding.tvBookId.text = item.id.toString()
            binding.tvBookName.text = item.title
            if (item.emprestado){
                binding.ivStatusBook.setImageResource(R.color.holo_red_light)
            }else {
                binding.ivStatusBook.setImageResource(R.color.holo_green_light)
            }

            val link : String = ("https://covers.openlibrary.org/b/id/" + item.covers.toString() + "-L.jpg")

            Glide.with(binding.root.context)
                .load(link).into(binding.ivBook)


        }
    }
}

class BookDiffCallback : DiffUtil.ItemCallback<Book>(){
    override fun areItemsTheSame(oldItem: Book, newItem: Book) = oldItem == newItem
    override fun areContentsTheSame(oldItem: Book, newItem: Book) = oldItem.id == newItem.id

}

