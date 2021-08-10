package co.ke.soundcloud.util

import co.ke.soundcloud.BuildConfig
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Class allows us to add a log interceptor to network calls when working in debug
 */
open class NetworkLogInterceptor {
    public open fun intercept() = HttpLoggingInterceptor().setLevel(
            when (BuildConfig.BUILD_TYPE) {
                "release" -> HttpLoggingInterceptor.Level.NONE
                else -> HttpLoggingInterceptor.Level.BODY
            }
    )
}