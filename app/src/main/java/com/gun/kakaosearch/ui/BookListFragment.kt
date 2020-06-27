package com.gun.kakaosearch.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.gun.kakaosearch.*
import com.gun.kakaosearch.domain.Book
import com.gun.kakaosearch.presenter.BaseFragment
import com.gun.kakaosearch.presenter.SearchBooksConstants
import com.gun.kakaosearch.ui.adapter.BooksListAdapter
import com.gun.kakaosearch.ui.util.EndlessRecyclerOnScrollListener
import kotlinx.android.synthetic.main.fragment_book_list.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BookListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookListFragment : Fragment(), BaseFragment {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var fragmentView: View

    lateinit var presenter: SearchBooksConstants.Presenter
    lateinit var booksAdapter: BooksListAdapter
    lateinit var endlessRecyclerScrollListener: EndlessRecyclerOnScrollListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_book_list, container, false)

        endlessRecyclerScrollListener = object : EndlessRecyclerOnScrollListener() {
            override fun onLoadMore() {
                presenter.searchMore()
            }
        }

        fragmentView.recycler_view.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = booksAdapter
            addOnScrollListener(endlessRecyclerScrollListener)
        }

        return fragmentView
    }

    fun addBooksList(booksList: List<Book>) {
        booksAdapter.addItem(booksList);
    }

    fun renewBooksList(booksList: List<Book>) {
        addBooksList(booksList)
        notifyDataSetChanged()
    }

    override fun getContext(): Context {
        return context
    }

    fun notifyDataSetChanged() {
        booksAdapter.notifyDataSetChanged()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BookListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BookListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun finishFragment() {
        val fragmentManager: FragmentManager = activity!!.supportFragmentManager
        fragmentManager.beginTransaction().remove(this).commit()
        fragmentManager.popBackStack()
    }
}
