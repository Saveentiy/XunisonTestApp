package xunison.com.testapp.di.module

import javax.inject.Inject

import okhttp3.Interceptor
import okhttp3.Response

class ServiceInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        var request = chain.request()
        request = request.newBuilder()
//            .addHeader("Content-Type", "application/json")
//            .addHeader("User-Agent", "PostmanRuntime/7.26.10")
//            .addHeader("Accept", "*/*")
//            .addHeader("Accept-Encoding", "gzip, deflate, br")
//            .addHeader("Connection", "keep-alive")keep-aliveΩ
            .build()

        return chain.proceed(request)
    }
}