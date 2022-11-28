package com.example.sari_saristorelog.util

sealed class QueryOrder{
    object Asc: QueryOrder()
    object Desc: QueryOrder()
    data class FromToDateAsc(val fromDate: Long = 0, val toDate: Long = Long.MAX_VALUE): QueryOrder()
    data class FromToDateDesc(val fromDate: Long = 0, val toDate: Long = Long.MAX_VALUE): QueryOrder()
}


