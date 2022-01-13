package com.atcoder.moviekotlin.api

import com.atcoder.moviekotlin.util.Constant
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object APIService {
    private var retrofit: Retrofit? = null

    val client: ClientInterface
        get() {
            val loggingInterceptor = HttpLoggingInterceptor()
            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            val builder = OkHttpClient.Builder()
            builder.readTimeout(60, TimeUnit.SECONDS)
            builder.connectTimeout(20, TimeUnit.SECONDS)
            builder.writeTimeout(60, TimeUnit.SECONDS)
            builder.addInterceptor(loggingInterceptor)

            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(Constant.BASE_URL).client(builder.build())
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(ClientInterface::class.java)
        }
}


//object APIService {
//    private val retrofit: Retrofit? = null
//    private const val BASE_URL = "\${BASE_URL}"
//
//    //                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//    val client: ClientInterface
//        get() {
//            val loggingInterceptor = HttpLoggingInterceptor()
//            loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//            val builder = Builder()
//            builder.readTimeout(30, TimeUnit.SECONDS)
//            builder.connectTimeout(30, TimeUnit.SECONDS)
//            builder.writeTimeout(30, TimeUnit.SECONDS)
//            builder.addInterceptor(loggingInterceptor)
//            val client: OkHttpClient = builder.build()
//            if (APIService.retrofit == null) {
//                APIService.retrofit = Retrofit.Builder()
//                    .baseUrl(APIService.BASE_URL)
//                    .client(client) //                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//            }
//            return APIService.retrofit!!.create(ClientService::class.java)
//        }
//}