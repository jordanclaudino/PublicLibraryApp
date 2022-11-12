package com.example.publiclibrary.data.model

import com.google.gson.annotations.SerializedName

data class Book(
    val id: Long,
    val isbn: String,
    @SerializedName("number_of_pages")
    val numberOfPages: Int,
    val covers: List<Long>,
    @SerializedName("isbn_10")
    val isbn10: List<String>,
    val publishers: List<String>,
    val title: String,
    @SerializedName("isbn_13")
    val isbn13: List<String>,
    @SerializedName("publish_date")
    val publishDate: String,
    @SerializedName("latest_revision")
    val latestRevision: Int,
    val revision: Int,
    val emprestado: Boolean
    )
