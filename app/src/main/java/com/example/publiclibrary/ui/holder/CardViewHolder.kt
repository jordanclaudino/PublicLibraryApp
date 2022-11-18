package com.example.publiclibrary.ui.holder

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.publiclibrary.data.model.Book
import com.example.publiclibrary.databinding.RepoBookBinding

class CardViewHolder(
    private val repoBookBinding: RepoBookBinding
) : RecyclerView.ViewHolder(repoBookBinding.root) {
    fun bindBook(book: Book){
        repoBookBinding.txtTitle.text = book.title
        repoBookBinding.txtCode.text = book.id.toString()
        if (book.emprestado){
            //TODO
        }
        Glide.with(repoBookBinding.root.context)
            .load(book.covers).into(repoBookBinding.ivCover)

        repoBookBinding.mcvBook.setOnClickListener{
            //TODO
        }
    }
}

