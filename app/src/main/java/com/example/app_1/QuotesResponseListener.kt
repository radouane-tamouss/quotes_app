package com.example.app_1

interface QuotesResponseListener {
    fun didFetch(response: List<QuotesResponse>, message : String)
    fun didError(message: String)
}