package com.example.app_1

import android.content.Context
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class RequestManager(mContext : Context) {

    var retrofit = Retrofit.Builder()
        .baseUrl("https://dataxpress.info/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun GetAllQuotes(listener: QuotesResponseListener){
        val call = retrofit.create(CallQuotes::class.java).CallQuotes()
        call.enqueue(object :Callback<List<QuotesResponse>>{
            override fun onResponse(
                call: Call<List<QuotesResponse>>,
                response: Response<List<QuotesResponse>>
            ) {
                if(!response.isSuccessful){
                    listener.didError(response.message())
                    return
                }
                response.body()?.let { listener.didFetch(it,response.message()) }
            }

            override fun onFailure(call: Call<List<QuotesResponse>>, t: Throwable) {
                t.message?.let { listener.didError(it) }
            }

        })

    }
    private interface CallQuotes{
        @GET("api/getInterventions.php?assign_tech=reda")

        fun CallQuotes(): Call<List<QuotesResponse>>

    }

}