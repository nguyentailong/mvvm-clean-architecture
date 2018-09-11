package com.example.tainguyen.mvvm.domain.models


data class ComicPagination(var offset: Int?,
                           var limit: Int?,
                           var total: Int?,
                           var count: Int?,
                           var comics: List<Comic>?)