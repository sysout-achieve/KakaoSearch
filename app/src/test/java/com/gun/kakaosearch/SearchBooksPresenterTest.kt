package com.gun.kakaosearch

import com.gun.kakaosearch.ui.SearchBooksActivity
import com.gun.kakaosearch.ui.presenter.SearchBooksPresenter
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class SearchBooksPresenterTest {

    @InjectMocks
    lateinit var searchBooksPresenter: SearchBooksPresenter

    @Mock
    lateinit var searchBooksActivity: SearchBooksActivity

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun onClearTest() {
        searchBooksPresenter.onClear()
        Mockito.verify(searchBooksActivity, Mockito.times(1)).notifyDataSetChanged()
    }

    @Test
    fun resetTest() {
        searchBooksPresenter.reset()
        Mockito.verify(searchBooksActivity, Mockito.times(1)).notifyDataSetChanged()
        Assert.assertEquals(searchBooksPresenter.pageCounter, 1)
        Assert.assertEquals(searchBooksPresenter.isEnd,false)
        Assert.assertEquals(searchBooksPresenter.keyword,"")
        Assert.assertEquals(searchBooksPresenter.booksList.size,0)
    }

    @Test
    fun searchMoreTest() {

    }

    @Test
    fun callBookListTest() {
//        searchBooksPresenter.callBookList("게")
//        print(searchBooksPresenter.keyword)
//        print(searchBooksPresenter.booksList.size)

//        RetrofitKakao.getService().requestSearchObservable(keyword = "게", page = 1)
//            .test().assertValue()
//            .dispose()
    }
}