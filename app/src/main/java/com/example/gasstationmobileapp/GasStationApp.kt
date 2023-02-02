package com.example.gasstationmobileapp

import android.app.Application
import com.example.gasstationmobileapp.data.remote.news.NewsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class GasStationApp: Application() {
    lateinit var newsApi: NewsApi


    override fun onCreate() {
        super.onCreate()

        //configureRetrofit()
    }

    //private fun configureRetrofit(){
    //    val httpLoggingInterceptor = HttpLoggingInterceptor()
    //    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
    //
    //    val okHttpClient = OkHttpClient.Builder()
    //        .addInterceptor(httpLoggingInterceptor)
    //        .build()
    //
    //    val retrofit = Retrofit.Builder()
    //        .baseUrl("")
    //        .client(okHttpClient)
    //        .addConverterFactory(GsonConverterFactory.create())
    //        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
    //        .build()
    //
    //    newsApi = retrofit.create(NewsApi::class.java)
    //}
}