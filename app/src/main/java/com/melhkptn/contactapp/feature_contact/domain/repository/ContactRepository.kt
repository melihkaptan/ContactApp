package com.melhkptn.contactapp.feature_contact.domain.repository

import com.melhkptn.contactapp.feature_contact.domain.model.ContactItem
import com.melhkptn.contactapp.feature_contact.domain.model.ContactRequest
import io.reactivex.Single

interface ContactRepository {

    fun getContactData(
        request: ContactRequest
    ): Single<List<ContactItem>>

}