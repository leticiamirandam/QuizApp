package com.leticiamirandam.quizapp.data.api

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

private const val API_KEY = ""

class AuthorizationInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        var request: Request = chain.request()
        request = request.newBuilder()
                .addHeader("X-Api-Key", API_KEY).build()
        return chain.proceed(request)
    }
}