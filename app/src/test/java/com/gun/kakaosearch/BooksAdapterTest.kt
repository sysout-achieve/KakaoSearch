package com.gun.kakaosearch

import com.gun.kakaosearch.api.RetrofitKakao
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class BooksAdapterTest {


    @Before
    fun setUp() {
    }

    @Test
    fun addTest() {
        callBookList("ㄱ", 2)
    }

    fun callBookList(name: String, page: Int) {
        var response = RetrofitKakao.getService().requestSearchBook(keyword = name, page = page).execute()
        System.out.println(response!!.isSuccessful)
        System.out.println(response.body()!!.bookList)
    }
}
