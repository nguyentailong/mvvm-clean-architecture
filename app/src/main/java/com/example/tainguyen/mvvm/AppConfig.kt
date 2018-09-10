package com.example.tainguyen.mvvm

import com.example.tainguyen.mvvm.AppConfig.KeyValue.Companion.COMIC_ID

class AppConfig {

    class ApiUrls {
        companion object {
            const val BASE_URL = "https://gateway.marvel.com/"
            const val COMICS = "v1/public/comics"
            const val COMIC_DETAIL = "v1/public/comics/$COMIC_ID"
        }
    }

    class KeyValue {
        companion object {
            const val COMIC_ID = "comicId"
        }
    }

    // Glide module
    val glideModuleName = "MyGlide"
    // SharedPreferences name
    val prefName = "cardbey_pref"
}
