package com.gun.kakaosearch.ui.presenter

import com.gun.kakaosearch.domain.Book
import com.gun.kakaosearch.ui.BaseView

interface SearchBooksConstants {


    interface View : BaseView {
        fun renewBooksList(booksList: List<Book>)
        fun notifyDataSetChanged()
    }
    // presenter는 ui, data를 같이 움직이기 때문에 함수명에서 data인지 view ui의 변경인지에 대한 구분 가능한 함수명으로 교체 예정
    interface Presenter : BasePresenter {
        //ui, data method 분류하여 method명 설정
        fun callBookList(name: String)
        fun getBooksArrList(): ArrayList<Book>
        fun onClear()
        fun reset()
        fun searchMore()
    }
}