package com.melhkptn.contactapp.feature_contact.data.source.remote

import com.melhkptn.contactapp.feature_contact.domain.util.Constants.CONTENT_TYPE
import com.melhkptn.contactapp.feature_contact.domain.util.Constants.JSON
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class DefaultRequestInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(with(chain.request().newBuilder()) {
            addHeader(CONTENT_TYPE, JSON)
            build()
        })
    }
}