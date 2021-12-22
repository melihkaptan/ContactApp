package com.melhkptn.contactapp.feature_contact.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.melhkptn.contactapp.R
import com.melhkptn.contactapp.feature_contact.domain.model.ContactItem

class ContactAdapter(private var contactList: ArrayList<ContactItem>) :
    RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    class ContactAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.textViewDeneme).text =
            contactList[position].name
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    fun updateContactList(list: List<ContactItem>) {
        contactList.clear()
        contactList.addAll(list)
        notifyDataSetChanged()
    }
}