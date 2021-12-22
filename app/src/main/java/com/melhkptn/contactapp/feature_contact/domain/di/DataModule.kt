package com.melhkptn.contactapp.feature_contact.domain.di

import android.app.Application
import androidx.room.Room
import com.melhkptn.contactapp.feature_contact.data.repository.ContactRepositoryImpl
import com.melhkptn.contactapp.feature_contact.data.source.local.ContactDatabase
import com.melhkptn.contactapp.feature_contact.data.source.local.ContactDatabase.Companion.DATABASE_NAME
import com.melhkptn.contactapp.feature_contact.data.source.remote.ContactAPI
import com.melhkptn.contactapp.feature_contact.domain.model.ContactItem
import com.melhkptn.contactapp.feature_contact.domain.repository.ContactRepository
import com.melhkptn.contactapp.feature_contact.domain.usecase.AddContact
import com.melhkptn.contactapp.feature_contact.domain.usecase.GetContacts
import com.melhkptn.contactapp.feature_contact.domain.usecase.UseCases
import com.melhkptn.contactapp.feature_contact.domain.usecase.base.BaseUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {


    @Provides
    @Singleton
    fun provideContactDatabase(application: Application): ContactDatabase {
        return Room.databaseBuilder(
            application,
            ContactDatabase::class.java,
            DATABASE_NAME
        ).fallbackToDestructiveMigration()
            .build()
    }


    @Provides
    @Singleton
    fun provideContactRepository(
        api: ContactAPI,
        database: ContactDatabase
    ): ContactRepository =
        ContactRepositoryImpl(
            api,
            database.contactDao()
        )

    @Provides
    @Singleton
    fun provideContactUseCase(
        contactRepository: ContactRepository
    ): BaseUseCase.RequestInteractor<GetContacts.Params, List<ContactItem>> =
        GetContacts(
            contactRepository
        )

    @Provides
    @Singleton
    fun provideUseCases(database: ContactDatabase) : UseCases =
        UseCases(
            addContact = AddContact(database)
        )
}