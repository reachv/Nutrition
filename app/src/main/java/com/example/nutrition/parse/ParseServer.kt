package com.example.nutrition.parse

import android.app.Application
import com.example.nutrition.R
import com.parse.Parse

class ParseServer : Application(){
    override fun onCreate() {
        super.onCreate()
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.applicationKey))
                .clientKey(getString(R.string.clientKey))
                .server("https://parseapi.back4app.com")
                .build()
        )
    }
}