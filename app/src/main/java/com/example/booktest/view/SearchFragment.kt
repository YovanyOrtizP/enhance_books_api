package com.example.booktest.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.booktest.R
import com.example.booktest.databinding.SearchFragmentBinding

class SearchFragment: Fragment() {

    private lateinit var binding: SearchFragmentBinding
    private lateinit var adapterFilter: ArrayAdapter<String>
    private lateinit var adapterBookType: ArrayAdapter<String>
    private lateinit var comunicator: Comunicator

    override fun onAttach(context: Context) {
        //fragment is going to be attach to an activity. An activity needs to exist first in order to
        //attach something. Here the context is going to be the main activity
        super.onAttach(context)
        when(context){
            is Comunicator -> comunicator = context
            else -> throw Exception("Incorrect Host Activity")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //Everytime we override the OnCreateView, we have to delete  the keyword "return"
        //return super.onCreateView(inflater, container, savedInstanceState)
        super.onCreateView(inflater, container, savedInstanceState)
        binding = SearchFragmentBinding.inflate(
            inflater, container, false
        )
        initViews()
        return binding.root
    }

    private fun initViews() {
        adapterFilter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            requireContext().resources.getStringArray(R.array.book_filter)
        )
        adapterBookType = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_list_item_1,
            requireContext().resources.getStringArray(R.array.book_print_type)
        )
        binding.apply {
            bookFilter.adapter = adapterFilter
            bookPrintType.adapter = adapterBookType
            buttonSearch.setOnClickListener { sendSearchParams() }
        }
    }

    private fun sendSearchParams() {
        binding.bookSearchTitle.editText?.text?.let {
            val bookTitle = it.toString()
            val bookFilter = binding.bookFilter.selectedItem.toString()
            val bookPrintType = binding.bookPrintType.selectedItem.toString()

            comunicator.sendDataToSearch(bookTitle,bookFilter,bookPrintType)
        }
    }
}