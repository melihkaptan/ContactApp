package com.melhkptn.contactapp.feature_contact.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.melhkptn.contactapp.feature_contact.domain.model.ContactItem

@Database(
    entities = [ContactItem::class],
    version = 5,
    exportSchema = false
)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun contactDao(): ContactDao

    companion object {
        const val DATABASE_NAME = "contacts_db"
    }
}