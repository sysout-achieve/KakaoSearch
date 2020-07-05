package com.gun.kakaosearch

import android.os.Build
import com.gun.kakaosearch.ui.MainActivity
import com.gun.kakaosearch.ui.SearchBooksActivity
import com.gun.kakaosearch.ui.presenter.SearchBooksPresenter
import junit.framework.Assert.assertEquals
import kotlinx.android.synthetic.main.layout_searchbar.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.shadows.ShadowLog


@RunWith(RobolectricTestRunner::class)
@Config(sdk = [Build.VERSION_CODES.O_MR1])
class SearchBooksActivityTest {
    //    var searchBooksPresenter = mock(SearchBooksPresenter::class)
    lateinit var activity: SearchBooksActivity
    lateinit var presenter: SearchBooksPresenter

    @Before
    fun setup() {
        ShadowLog.stream = System.out;

        activity = Robolectric.setupActivity(
            SearchBooksActivity::class.java
        )  // 1
        presenter = Mockito.mock(SearchBooksPresenter::class.java)
        activity.presenter = presenter
//        var activityController = Robolectric
//            .buildActivity(SearchBooksActivity::class.java)
//            .setup()
//        //when
//        activityController.resume()
//        presenter = Mockito.mock(SearchBooksPresenter::class.java)
//        activity.presenter = presenter
    }

    @Test
    fun et_search_hint_right() {
        activity = Robolectric.setupActivity(
            SearchBooksActivity::class.java
        )  // 1
        assertEquals(activity.getString(R.string.search), activity.edit_search.hint)   // 2
    }

    @Test
    fun searchTest() {
        var str = "감"
        activity.searchText(str)
        Mockito.verify(presenter, Mockito.times(1)).reset()
        Mockito.verify(presenter, Mockito.times(1)).callBookList(str)
    }

    fun searchStrTest(str: String) {
        activity.searchText(str)
    }
}