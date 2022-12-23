package com.example.booktest.model

class BookResponse (
    val totalItems: Int,
    val items: List<Books>,
        )

data class Books(
    val volumeInfo: BooksVolumeInfo
)

data class BooksVolumeInfo(
    val title: String,
    val printType: String,
    val imageLinks: BooksImageLink,
    val previewLink: String,
    val subtitle: String?, //Could be null or no
    val authors: List<String>? //Could be null or no
)

data class BooksImageLink(
    val smallThumbnail: String,
    val thumbnail: String
)
