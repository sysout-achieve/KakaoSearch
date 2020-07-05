package com.gun.kakaosearch.ui.presenter

import com.gun.kakaosearch.domain.Book
import com.gun.kakaosearch.ui.BaseView

interface SearchBooksConstants {


    interface View : BaseView {
        fun renewBooksList(booksList: List<Book>)
        fun notifyDataSetChanged()
    }

    interface Presenter : BasePresenter {
        fun callBookList(name: String)
        fun getBooksArrList(): ArrayList<Book>
        fun onClear()
        fun reset()
        fun searchMore()
    }
}