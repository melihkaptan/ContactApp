package com.melhkptn.contactapp.feature_contact.domain.model

import com.google.gson.annotations.SerializedName

data class ContactRequest(
    @SerializedName("page")
    val page: String? = null,
    @SerializedName("limit")
    val limit: String? = null
)