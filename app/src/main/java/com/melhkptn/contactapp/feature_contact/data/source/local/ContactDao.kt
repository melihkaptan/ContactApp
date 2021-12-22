package com.melhkptn.contactapp.feature_contact.data.source.local

import androidx.room.*
import com.melhkptn.contactapp.feature_contact.domain.model.ContactItem
import io.reactivex.Single

@Dao
interface ContactDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg contactItem: ContactItem) : List<Long>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertContact(contactItem: ContactItem)

    @Query("SELECT * FROM contactitem")
    fun getAllContact() : Single<List<ContactItem>>

    @Delete
    fun deleteContact(contactItem: ContactItem)
}