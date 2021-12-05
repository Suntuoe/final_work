package com.example.cpc10

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val bookImgeView: ImageView = itemView.findViewById(R.id.book_image_view)
    private val booktytleTextView: TextView = itemView.findViewById(R.id.book_title_text_view)

    fun bind(book:Book) {
        bookImgeView.setImageResource(book.image)
        booktytleTextView.text = book.tytle
    }
}