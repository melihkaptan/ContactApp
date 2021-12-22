package com.melhkptn.contactapp.feature_contact.domain.usecase

import com.melhkptn.contactapp.feature_contact.data.source.local.ContactDatabase
import com.melhkptn.contactapp.feature_contact.domain.model.ContactItem

class AddContact(
    private val database: ContactDatabase
){

    suspend operator fun invoke(contact: ContactItem){
        database.contactDao().insertContact(contact)
    }
}