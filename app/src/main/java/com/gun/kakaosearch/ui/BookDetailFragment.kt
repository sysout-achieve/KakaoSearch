package com.gun.kakaosearch.ui

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.gun.kakaosearch.ui.presenter.BaseFragment
import com.gun.kakaosearch.R
import com.gun.kakaosearch.domain.Book
import kotlinx.android.synthetic.main.fragment_book_detail.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookDetailFragment : Fragment(), BaseFragment {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        var view = inflater.inflate(R.layout.fragment_book_detail, container, false)
        view.img_close.setOnClickListener { v ->
            finishFragment()
        }

        val body = arguments?.getString("body")
        val book = Gson().fromJson(body, Book::class.java)

        Glide.with(this).load(book.thumbnail).into(view.imgv_thumbnail)
        view.tv_title.text = book.title
        view.tv_author.text = book.authors.toString()
        view.tv_publisher.text = book.publisher
        view.tv_price.text = setPriceStr(book.price.toString())
        view.tv_price.paintFlags = view.tv_price.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        view.tv_sale_price.text = setPriceStr(book.sale_price.toString())
        view.tv_contents.text = book.contents


        // Inflate the layout for this fragment
        return view
    }

    override fun finishFragment() {
        val fragmentManager: FragmentManager = activity!!.supportFragmentManager
        fragmentManager.beginTransaction().remove(this).commit()
        fragmentManager.popBackStack()
    }

    fun setPriceStr(price: String): String {
        return price + "원"
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BookDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}
