package com.example.tainguyen.mvvm.data.network

import com.example.tainguyen.mvvm.AppConfig
import com.example.tainguyen.mvvm.AppConfig.KeyValue.Companion.COMIC_ID
import com.example.tainguyen.mvvm.data.network.models.ComicResponse
import io.reactivex.Single
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ComicService {

    @GET(AppConfig.ApiUrls.COMICS)
    fun getComics(): Single<Response<ComicResponse>>

    @GET(AppConfig.ApiUrls.COMIC_DETAIL)
    fun getComicDetails(@Path(COMIC_ID) comicId: String): Single<Response<ComicResponse>>

}