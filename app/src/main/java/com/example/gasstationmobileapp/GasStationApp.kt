package com.example.gasstationmobileapp

import android.app.Application
import com.example.gasstationmobileapp.data.remote.news.NewsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import com.yandex.mapkit.MapKitFactory

class GasStationApp: Application() {
    lateinit var newsApi: NewsApi
    private var MAPKIT_API_KEY = "15f9ab7e-e532-4dc0-b701-c9ab368d40a5"


    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey(MAPKIT_API_KEY)

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