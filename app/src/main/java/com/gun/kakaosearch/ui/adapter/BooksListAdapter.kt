package com.gun.kakaosearch.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gun.kakaosearch.R
import com.gun.kakaosearch.domain.Book
import kotlinx.android.synthetic.main.item_book.view.*

class BooksListAdapter constructor(private var items: ArrayList<Book>) : RecyclerView.Adapter<BooksListAdapter.MainViewHolder>() {

    private lateinit var itemClickListner: ItemClickListener

    interface ItemClickListener {
        fun onClick(view: View, data: Book)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        items[position].let { item ->
            with(holder) {
                tvTitle.text = item.title
                tvContent.text = item.contents
                imgv_thumbnail.loadUrl(item.thumbnail)
            }
        }
        holder.itemView.setOnClickListener {
            itemClickListner.onClick(it, items[position])
        }
    }

    fun setOnItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListner = itemClickListener
    }

    fun addItem(bookList: List<Book>) {
        items.addAll(bookList)
    }

    inner class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle = itemView.tv_title
        val tvContent = itemView.tv_contents
        val imgv_thumbnail = itemView.imgv_thumbnail
    }

    fun ImageView.loadUrl(imageUrl: String?) {
        Glide.with(this).load(imageUrl).into(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        var view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_book, parent, false)
        return MainViewHolder(view)
    }
}
