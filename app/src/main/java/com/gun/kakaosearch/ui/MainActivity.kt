package com.gun.kakaosearch.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gun.kakaosearch.R
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupTimber()
        init()
    }

    private fun init() {
        val nextIntent = Intent(this, SearchBooksActivity::class.java)
        startActivity(nextIntent)
        finish()
    }


    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }
}
