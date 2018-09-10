package com.example.tainguyen.mvvm.domain.models

data class ComicEntity(var id: String,
                       var description: String,
                       var title: String,
                       var prices: Double,
                       var thumbnail: String,
                       var images: List<String>)