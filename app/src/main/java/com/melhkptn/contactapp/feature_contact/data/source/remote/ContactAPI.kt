package com.melhkptn.contactapp.feature_contact.data.source.remote

import com.melhkptn.contactapp.feature_contact.domain.model.ContactItem
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ContactAPI {
    @GET("contacts")
    fun getContact(
        @Query("page") page: String? = null,
        @Query("limit") limit: String? = null
    ): Single<List<ContactItem>>
}