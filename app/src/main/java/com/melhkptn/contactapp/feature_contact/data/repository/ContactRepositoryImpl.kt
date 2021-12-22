package com.melhkptn.contactapp.feature_contact.data.repository

import android.annotation.SuppressLint
import android.util.Log
import com.melhkptn.contactapp.feature_contact.data.source.local.ContactDao
import com.melhkptn.contactapp.feature_contact.data.source.remote.ContactAPI
import com.melhkptn.contactapp.feature_contact.domain.model.ContactItem
import com.melhkptn.contactapp.feature_contact.domain.model.ContactRequest
import com.melhkptn.contactapp.feature_contact.domain.repository.ContactRepository
import io.reactivex.Single
import javax.inject.Inject

class ContactRepositoryImpl @Inject constructor(
    private val api: ContactAPI,
    private val dao: ContactDao
) : ContactRepository {
    @SuppressLint("CheckResult")
    override fun getContactData(request: ContactRequest): Single<List<ContactItem>> =
        api.getContact()
            .onErrorResumeNext { throwable ->
                if (throwable is Exception) {
                    Log.d("Error", throwable.localizedMessage)
                    return@onErrorResumeNext dao.getAllContact()
                } else {
                    return@onErrorResumeNext Single.error(throwable)
                }
            }
}