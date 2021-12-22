package com.melhkptn.contactapp.feature_contact.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.melhkptn.contactapp.feature_contact.data.source.local.ContactDatabase
import com.melhkptn.contactapp.feature_contact.domain.model.ContactItem
import com.melhkptn.contactapp.feature_contact.domain.usecase.GetContacts
import com.melhkptn.contactapp.feature_contact.domain.usecase.UseCases
import com.melhkptn.contactapp.feature_contact.domain.usecase.base.BaseUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(
    private val getContacts: BaseUseCase.RequestInteractor<GetContacts.Params, List<ContactItem>>,
    private val database: ContactDatabase,
    private val useCases: UseCases
) : BaseViewModel() {

    private val _contactList = MutableLiveData<List<ContactItem>>()
    val contactList: LiveData<List<ContactItem>>
        get() = _contactList

    fun getContactList() {
        getContacts.fetch(
            compositeDisposable, GetContacts.Params()
        ) {
            _contactList.value = it
        }
    }

    suspend fun addContactList(list: List<ContactItem>){
        database.contactDao().insertAll(*list.toTypedArray())
    }

    fun addContact(contact : ContactItem){
        viewModelScope.launch {
            useCases.addContact.invoke(contact)
        }
    }

}