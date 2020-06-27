package com.gun.kakaosearch.ui

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.gun.kakaosearch.R
import com.gun.kakaosearch.presenter.SearchBooksConstants
import com.gun.kakaosearch.presenter.SearchBooksPresenter
import com.gun.kakaosearch.domain.Book
import com.gun.kakaosearch.ui.adapter.BooksListAdapter
import kotlinx.android.synthetic.main.layout_searchbar.*

class SearchBooksActivity : AppCompatActivity(),
    SearchBooksConstants.View {

    private val bookListFragment: BookListFragment by lazy { BookListFragment() }
    private val bookDetailFragment: BookDetailFragment by lazy { BookDetailFragment() }
    var presenter: SearchBooksConstants.Presenter =
        SearchBooksPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_books)
        btn_search.setOnClickListener { view ->
            this.hideKeyboard(view)
            searchText()
        }
        val booksAdapter = BooksListAdapter(presenter.getBooksArrList())
        booksAdapter.setOnItemClickListener(object :
            BooksListAdapter.ItemClickListener {
            override fun onClick(view: View, book: Book) {
                var bundle = Bundle()
                val jsonBody = Gson().toJson(book)
                bundle.putString("body", jsonBody)
                bookDetailFragment.arguments = bundle
                addStackFragment(R.id.container_detail, bookDetailFragment, "detail")
            }
        })
        bookListFragment.presenter = presenter
        bookListFragment.booksAdapter = booksAdapter

        addStackFragment(R.id.container_list, bookListFragment, "list")
    }

    @Synchronized
    fun addStackFragment(resId: Int, fragment: Fragment, tag: String) {
        if (supportFragmentManager.backStackEntryCount <= 1) {
            supportFragmentManager.beginTransaction()
                .add(resId, fragment).addToBackStack(tag)
                .commit()
        }
    }

    fun searchText() {
        presenter.reset()
        presenter.callBookList(edit_search.text.toString())
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
            return
        }
        finish()
    }

    override fun renewBooksList(booksList: List<Book>) {
        bookListFragment.renewBooksList(booksList)
    }

    override fun notifyDataSetChanged() {
        bookListFragment.notifyDataSetChanged()
    }

    override fun showError(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }
}


