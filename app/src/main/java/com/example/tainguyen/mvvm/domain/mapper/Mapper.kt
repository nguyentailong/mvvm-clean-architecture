package com.example.tainguyen.mvvm.domain.mapper

abstract class Mapper<From, To> {

    abstract fun map(from: From): To

    /**
     * Returns a list containing the results of applying [map] function
     * to each element in the [fromList] collection.
     */
    fun map(fromList: List<From>?): List<To>? {
        return fromList?.map(this::map)
    }
}
