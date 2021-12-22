package com.melhkptn.contactapp.feature_contact.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class ContactItem(
    @SerializedName("company_name")
    val company_name: String?,
    @SerializedName("createdAt")
    val createdAt: String?,
    @SerializedName("department")
    val department: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("number")
    val number: Int?,
    @SerializedName("surname")
    val surname: String?,

    @SerializedName("id")
    @PrimaryKey
    val id: Int?
)