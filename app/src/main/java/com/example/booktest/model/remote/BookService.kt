package com.example.booktest.model.remote

import com.example.booktest.model.BookResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface BookService {
    //https://www.googleapis.com/books/v1/volumes?q=bible&printType=books&filter=ebooks
    @GET(ENDPOINT)
    fun getNextBookPage(
        @Query(PARAM_Q) bookTitle:String,
        @Query(PARAM_FILTER) bookFilter: String,
        @Query(PARAM_PRINT_TYPE) bookType: String,
        @Query(PARAM_START_INDEX) pageIndex: Int
    ):Call<BookResponse>
}
/*
1. Add the library dependency
2. Create the service interface
3. Define the HTTP verbs in the interface
4. Create the Retrofit object
5. Invoke wither enqueue or execute
 */