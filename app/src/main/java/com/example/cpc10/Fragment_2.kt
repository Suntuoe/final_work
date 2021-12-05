package com.example.cpc10

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Fragment_2 : Fragment() {

    lateinit var bookRecyclerView: RecyclerView
    lateinit var findinternetButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_2, container, false)


        val bookList: List<Book> = listOf(
        Book("Android сборник рецептов", R.drawable.book1),
        Book("Head First программирование для Android", R.drawable.book2),
        Book("Android программирование для профессионалов", R.drawable.book3),
        Book("Android для разработчиков", R.drawable.book4)
        )

        bookRecyclerView = view.findViewById(R.id.book_recycler_view)
        bookRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        bookRecyclerView.adapter = BookAdapter(bookList)


        findinternetButton = view.findViewById(R.id.findinternet_button)
        findinternetButton.setOnClickListener {
            val link = Uri.parse("https://google.com/search?q=android+programming+books")
            val intent = Intent(Intent.ACTION_VIEW, link)
            context?.startActivity(intent)
        }

        return view
    }


}