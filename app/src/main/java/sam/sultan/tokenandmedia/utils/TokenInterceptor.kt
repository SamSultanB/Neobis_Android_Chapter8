package sam.sultan.tokenandmedia.utils

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor(private val token: String): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originRequest = chain.request()

        val authenticatedRequest = originRequest.newBuilder()
            .header("Authorization", "Bearer $token").build()

        return chain.proceed(authenticatedRequest)
    }
}