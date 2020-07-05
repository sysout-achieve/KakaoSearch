package com.gun.kakaosearch.ui.presenter

import com.gun.kakaosearch.api.RetrofitKakao
import com.gun.kakaosearch.domain.Book
import com.gun.kakaosearch.domain.ResultBook
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

open class SearchBooksPresenter(var searchBooksView: SearchBooksConstants.View?) :
    SearchBooksConstants.Presenter {

    var booksList = ArrayList<Book>()
    var pageCounter = 1
    var isEnd = false

    var keyword: String = ""

    override fun callBookList(name: String) {
        if (name.equals("")) {
            searchBooksView!!.showError("정확히 입력해주세요")
            return
        }
        RetrofitKakao.getService().requestSearchBook(keyword = name, page = pageCounter)
            .enqueue(object : Callback<ResultBook> {
                override fun onResponse(call: Call<ResultBook>, response: Response<ResultBook>) {
                    if (response.isSuccessful) {
                        keyword = name
                        val resultBook = response.body()
                        isEnd = resultBook!!.isEnd()
                        searchBooksView?.renewBooksList(resultBook!!.bookList)
                    } else {
                        response.errorBody()?.string()?.let { searchBooksView!!.showError(it) }
                    }
                }

                override fun onFailure(call: Call<ResultBook>, t: Throwable) {
                    t.stackTrace
                    Timber.e(t)
                }
            })
    }

//    fun callBookListObservable(name: String){
//        RetrofitKakao.getService().requestSearchObservable(keyword = name, page = pageCounter).test().dispose()
//    }

    override fun getBooksArrList(): ArrayList<Book> {
        return booksList
    }

    override fun onClear() {
        booksList.clear()
        searchBooksView!!.notifyDataSetChanged()
    }

    override fun reset() {
        pageCounter = 1
        isEnd = false
        keyword = ""
        onClear()
    }

    override fun searchMore() {
        pageCounter++
        if (!keyword.equals("") && !isEnd) {
            callBookList(keyword)
        }
    }

    override fun destroyView() {
        searchBooksView = null
    }
}