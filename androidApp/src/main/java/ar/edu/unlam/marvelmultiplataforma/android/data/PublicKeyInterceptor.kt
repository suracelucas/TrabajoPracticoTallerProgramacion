package ar.edu.unlam.marvelmultiplataforma.android.data

import ar.edu.unlam.marvelmultiplataforma.android.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class PublicKeyInterceptor :Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url()

        val newUrl = url.newBuilder().addQueryParameter("apiKey", BuildConfig.PUBLIC_KEY).build()

        return chain.proceed(request.newBuilder().url(newUrl).build())
    }
}