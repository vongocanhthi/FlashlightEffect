package com.atcoder.moviekotlin.api

import com.atcoder.moviekotlin.model.Movie
import com.atcoder.moviekotlin.model.MovieResponse
import com.atcoder.moviekotlin.model.UserResponse
import com.atcoder.moviekotlin.util.Constant
import io.reactivex.Single
import retrofit2.http.*


interface ClientInterface {
    @Headers(Constant.APP_TOKEN)
    @GET("movie/list")
    fun getMovieList(): Single<MovieResponse<List<Movie>>>

    @Headers(Constant.APP_TOKEN)
    @FormUrlEncoded
    @POST("movie/list")
    fun getMoviePage(@Field("page") page: Int?): Single<MovieResponse<List<Movie>>>

    @Headers(Constant.APP_TOKEN)
    @FormUrlEncoded
    @POST("user/login")
    fun getLoginData(
        @Field("email") email: String?,
        @Field("password") password: String?
    ): Single<UserResponse>

    @Headers(Constant.APP_TOKEN)
    @FormUrlEncoded
    @POST("user/registry")
    fun getRegisterData(
        @Field("full_name") fullname: String?,
        @Field("email") email: String?,
        @Field("password") password: String?
    ): Single<UserResponse>

    @Headers(Constant.APP_TOKEN)
    @FormUrlEncoded
    @POST("user/forgot-password")
    fun getForgotpasswordData(@Field("email") email: String?): Single<UserResponse>
}

