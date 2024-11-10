package com.devspace.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

//Adaptação entre o Data Class e o item_list.xml
class ContactListAdapter :
    ListAdapter<Contact, ContactListAdapter.ContactViewHolder>(ContactDiffUtils()) {

    private lateinit var onClickListener: (Contact) -> Unit

    //Criar um ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ContactViewHolder(view)
    }

    //Bind - Liga os dados com a View(UI)
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact, onClickListener)
    }

    fun setOnClickListener(onClick: (Contact) -> Unit) {
        onClickListener = onClick
    }

    //ViewHolder = View que segura os dados
    class ContactViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val textViewName = view.findViewById<TextView>(R.id.textView_name)
        private val textViewPhone = view.findViewById<TextView>(R.id.textView_phone)
        private val imageView = view.findViewById<ImageView>(R.id.imageView)

        fun bind(contact: Contact, onClick: (Contact) -> Unit) {
            textViewName.text = contact.name
            textViewPhone.text = contact.phone
            imageView.setImageResource(contact.icon)

            view.setOnClickListener {
                onClick.invoke(contact)
            }
        }
    }

    //Compara a diferença quando a  nossa lista é atualizada
    class ContactDiffUtils : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem.name == newItem.name
        }

    }
}